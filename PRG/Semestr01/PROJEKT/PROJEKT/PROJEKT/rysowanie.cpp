/*Zad 166. Napisz program rysowania znakiem ASCII ponizszej figury.Program powinien
umozliwic:
- wybór znaku kodu ASCII
- wczytanie poczatkowych rozmiarów figury
- powiekszanie oraz zmniejszanie rozmiaru figury za pomoca klawiszy + i -
- przesuwanie figury klawiszami ›, ‹, ^, ¡
- ograniczenie przesuwania i rozmiarów figury do obszaru ekranu
.
.           *
.       *
.   *
.       *
.           x
.
Uwaga: punkt poczatkowy (kropka) znajduje sie w prawym dolnym narozniku ekranu.
-----------------------
Twórca: Filip Krzysztofik
Grupa: 5
*/

#define NOMINMAX

#include <iostream>
#include <conio.h>
#include <Windows.h>
#include <limits>

using namespace std;

const int GORA = 72, DOL = 80, LEWO = 75, PRAWO = 77, PLUS = 43, MINUS = 45, ESC = 27, ENTER = 13;
const int ROZMIAR_MAX = 12, ROZMIAR_MIN = 1;

COORD KONSOLA;

struct Figura
{
	char znak;
	int rozmiar;
	int pos_x;
	int pos_y;
};

void PokazMenu() {
	cout << "Witaj w programie rysowania za pomoca znakow ASCII!\n"
		<< "\nOto menu glowne, w ktorym:"
		<< "\n- mozesz wybrac wstepna wielkosc figury"
		<< "\n- mozesz wybrac znak ASCII wpisujac go lub jego numer"
		<< "\n- poruszac figura za pomoca strzalek"
		<< "\n- zmienic jej rozmiar za pomoca klawisza + i -"
		<< "\n- wyjsc z programu za pomoca klawisza ESC lub ENTER" << endl;
	cout << "\nNacisnij dowolny klawisz, aby przejsc do wstepnej konfiguracji\n\n";

	_getch();

	system("cls");
}

void Ustawienia(char &znak, int &rozmiar) {
	int wybor;

	do {
		system("cls");
		cout << "Chcesz wpisac znak czy kod ASCII? (1 - znak, 2 - ASCII)" << endl;
		cin >> wybor;
		if (cin.fail() || wybor != 1 || wybor != 2) {
			cin.clear();
			cin.ignore(numeric_limits < streamsize >::max(), '\n');		// numeric_limits <"zasieg" liczby>::max() - pobiera "zasieg" i wybiera najwieksza liczbe z "streamsize"
		}
	} while (wybor != 1 && wybor != 2);

	if (wybor == 1) {
		cout << "Wpisz znak: ";
		cin >> znak;
	}

	if (wybor == 2) {
		int znak_ascii;
		do {
			cout << "Wpisz kod ASCII: ";
			cin >> znak_ascii;
			if (cin.fail() || znak_ascii < 0 || znak_ascii > 255) {
				cin.clear();
				cin.ignore(numeric_limits < streamsize >::max(), '\n');
			}
		} while (cin.fail() || znak_ascii < 0 || znak_ascii > 255);

		znak = unsigned char(znak_ascii);
	}

	do {
		cout << "\nPodaj poczatkowy rozmiar figury (" << ROZMIAR_MIN << "-" << ROZMIAR_MAX << "): ";
		cin >> rozmiar;

		if (cin.fail() || rozmiar < ROZMIAR_MIN || rozmiar > ROZMIAR_MAX) {
			cin.clear();
			cin.ignore(numeric_limits < streamsize >::max(), '\n');
		}

	} while (rozmiar < ROZMIAR_MIN || rozmiar > ROZMIAR_MAX);

	cout << "\nWybrany znak: " << znak << endl;
	cout << "Wybrany poczatkowy rozmiar: " << rozmiar << endl;
	cout << "Pozycja poczatkowa (x,y) oraz rozmiar konsoli: (" << KONSOLA.X << "," << KONSOLA.Y << ")" << endl;
	cout << "Zakres rozmiaru figury: " << ROZMIAR_MIN << "-" << ROZMIAR_MAX << endl;
	cout << "Punkt zaczepienia oznaczony znakiem 'x' (jesli zostal wybrany znak x, to bedzie to znak 'o')" << endl;
	cout << "Przejdzmy do rysowania...";
	_getch();
	system("cls");
}

void UstawKursor(short x, short y) {
	COORD kursor = { x, y };
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), kursor);
}

void RysowanieFigury(int x, int y, int &rozmiar, char znak) {

	for (int i = 0; i < rozmiar; i++) {		// rysowanie od punktu zaczepienia
		UstawKursor(x, y);
		if (i == 0) {
			if (znak == 'x') { cout << "o"; }
			else { cout << "x"; }
		}
		else { cout << znak; }
		x = x - 2;
		y--;
	}
	for (int i = 0; i <= rozmiar; i++) {
		UstawKursor(x, y);
		cout << znak;
		x = x + 2;
		y--;
	}

	UstawKursor(2, 29);		// miejsce na wypisanie tekstu
	cout << "+/- - zmien rozmiar  | Strzalki - poruszanie sie\n  ESC - zamknij program";
}

void ZmienPozycje(int &x, int &y, int rozmiar, int klawisz) {
	if (klawisz == GORA && y - 2*rozmiar > 0) {
		y--;
	}
	if (klawisz == DOL && y < (int)KONSOLA.Y) {
		y++;
	}
	if (klawisz == PRAWO && x < (int)KONSOLA.X) {
		x++;
	}
	if (klawisz == LEWO && x - 2*rozmiar > 0) {
		x--;
	}
}

void ZmienRozmiar(int &x, int &y, int &rozmiar, int klawisz) {
	if (klawisz == PLUS) {
		if (rozmiar < ROZMIAR_MAX && y-2*rozmiar > 1 && x-2*rozmiar > 1) {
			rozmiar++;
		}
	}
	if (klawisz == MINUS && rozmiar > ROZMIAR_MIN) {
			rozmiar--;
	}
}

void Rysuj(int &x, int &y, int &rozmiar, char znak) {

	int klawisz;
	do {
		system("cls");
		RysowanieFigury(x, y, rozmiar, znak);
		klawisz = _getch();
		switch (klawisz) {
		case GORA:
		case DOL:
		case PRAWO:
		case LEWO: {
			ZmienPozycje(x, y, rozmiar, klawisz);
			break;
		}
		case PLUS:
		case MINUS: {
			ZmienRozmiar(x, y, rozmiar, klawisz);
			break;
		}
		case ESC:
		case ENTER: break;
		}
	} while (klawisz != ESC && klawisz != ENTER);
}


int main() {
	KONSOLA = { 90, 30 };
	SMALL_RECT rozmiarOkna = { 0,0, 90, 30 };		// "maly prostokat", lewo, gora, prawo, gora (x,y) i (x,y) naroznych punktow
	HANDLE uchwytOkna = GetStdHandle(STD_OUTPUT_HANDLE);
	SetConsoleScreenBufferSize(uchwytOkna, KONSOLA);
	SetConsoleWindowInfo(uchwytOkna, 1, &rozmiarOkna);

	Figura figura;
	figura.pos_x = KONSOLA.X;
	figura.pos_y = KONSOLA.Y;

	PokazMenu();
	Ustawienia(figura.znak, figura.rozmiar);
	Rysuj(figura.pos_x, figura.pos_y, figura.rozmiar, figura.znak);

	return EXIT_SUCCESS;
}