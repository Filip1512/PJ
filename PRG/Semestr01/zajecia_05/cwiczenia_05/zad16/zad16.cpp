#include <iostream>
#include <math.h>
#include <conio.h>
#include <time.h>

using namespace std;

void CzytajDane(int &n, int rozmiar_tablicy, int tablica_liczb[]) {

	const int MIN_WIELKOSC_TABLICY = 2;

	do {
		cout << "Podaj wielkosc tablicy n (" << MIN_WIELKOSC_TABLICY << "-" << rozmiar_tablicy << "): ";
		cin >> n;

		if (n < 2 || n > rozmiar_tablicy) {
			cout << "Podaj liczbe z przedzialu " << MIN_WIELKOSC_TABLICY << "-" << rozmiar_tablicy << "!\n";
			_getch();
			system("cls");
		}

	} while (n < MIN_WIELKOSC_TABLICY || n > rozmiar_tablicy);

	cout << "\nrozmiar tablicy n = " << n;

	//wypelnienie tablic
	cout << "\n\nZ jakiego przedzialu losowac liczby?";
	int przedzial_min, przedzial_max;
	cout << "\nmin: ";
	cin >> przedzial_min;
	cout << "max: ";
	cin >> przedzial_max;

	for (int i = 0; i < n; i++) {
		tablica_liczb[i] = rand() % przedzial_max + przedzial_min;
	}
	for (int i = n; i < rozmiar_tablicy; i++) {
		tablica_liczb[i] = 0;
	}
	// koniec
}

void PiszTablice(int tablica_liczb[], int n) {

	cout << "\nObecna tablica liczb: \n\n";
	for (int i = 0; i < n; i++) {
		cout << "[" << i << "]=" << tablica_liczb[i] << "\t";
	}
}

void Srednia(int tab[], int n) {
	double srednia = 0;

	for (int i = 0; i < n; i++) {
		srednia += tab[i];
	}
	srednia /= n;

	cout << "\n\nSrednia arytmetyczna = " << srednia;
}

void LiczbaWystapienElementow(int tab[], int n) {

	int liczba, suma = 0;

	cout << "\n\nPodaj liczbe, a podam Ci ile razy wystapila ona w tablicy: ";
	cin >> liczba;

	for (int i = 0; i < n; i++) {
		if (tab[i] == liczba) {
			suma++;
		}
	}

	cout << "Liczba " << liczba << " wystapila " << suma << " razy.";
}

void LiczbaOrazSumaLiczbNieparzystych(int tab[], int n) {

	int iloscNieparzystych = 0, suma = 0;

	for (int i = 0; i < n; i++) {
		if (tab[i] % 2) {
			iloscNieparzystych++;
			suma += tab[i];
		}
	}

	cout << "\n\nIlosc liczb nieparzystych: " << iloscNieparzystych << endl;
	cout << "Ich suma: " << suma;
}

void NajmniejszyElement(int tab[], int n) {

	int najmniejszyElement = tab[0], iloscElementow = 1, idElementu = 0;

	for (int i = 1; i < n; i++) {
		if (najmniejszyElement > tab[i]) {
			najmniejszyElement = tab[i];
			idElementu = i;
		}
		else if (najmniejszyElement == tab[i]) {
			iloscElementow++;
		}
	}

	cout << "\n\nNajmniejszy element tablicy to " << najmniejszyElement << ". \nW tablicy wystepuje " << iloscElementow << " takich elementow, a indeks jednego z nich jest rowny " << idElementu;
}

void NajwiekszyElement(int tab[], int n) {

	int najwiekszyElement = tab[0], iloscElementow = 1, idElementu = 0;

	for (int i = 1; i < n; i++) {
		if (najwiekszyElement < tab[i]) {
			najwiekszyElement = tab[i];
			idElementu = i;
		}
		else if (najwiekszyElement == tab[i]) {
			iloscElementow++;
		}
	}

	cout << "\n\nNajwiekszy element tablicy to " << najwiekszyElement << ". \nW tablicy wystepuje " << iloscElementow << " takich elementow, a indeks jednego z nich jest rowny " << idElementu;
}

void NajwiekszaSumaSasiednichPar(int tab[], int n) {

	int najwiekszaSuma = tab[0] + tab[1], id1 = 0, id2 = 0;

	for (int i = 1; i < n - 1; i++) {
		if (najwiekszaSuma < tab[i] + tab[i + 1]) {
			najwiekszaSuma = tab[i] + tab[i + 1];
			id1 = i;
			id2 = i + 1;
		}
	}
	cout << "\n\nPara sasiednich elementow o najwiekszej sumie to: " << endl;
	cout << "[" << id1 << "]" << " = " << tab[id1];
	cout << "\n[" << id2 << "]" << " = " << tab[id2];
	cout << "\nIch suma to: " << najwiekszaSuma;
}

void NajczesciejWystepujacyElement(int tab[], int n) {

	int nwe;							// najczesciej wystepujacy element
	int sprawdzany_element;
	int liczba_nwe = 0;
	int liczba_wystapien_sprawdzanego_elementu;

	for (int i = 0; i < n; i++) {
		sprawdzany_element = tab[i];
		liczba_wystapien_sprawdzanego_elementu = 0;

		for (int j = 0; j < n; j++) {
			if (sprawdzany_element == tab[j]) {
				liczba_wystapien_sprawdzanego_elementu++;
			}
			if (liczba_nwe < liczba_wystapien_sprawdzanego_elementu) {
				nwe = sprawdzany_element;
				liczba_nwe = liczba_wystapien_sprawdzanego_elementu;
			}
		}
	}

	cout << "\n\nPierwszy najczesciej wystepujacy element to " << nwe << ". Wystepuje on " << liczba_nwe << " razy.";
}


int main() {

	srand(time(NULL));

	const int ROZMIAR_TABLICY = 100;

	int n;
	int tablica_liczb[ROZMIAR_TABLICY];

	CzytajDane(n, ROZMIAR_TABLICY, tablica_liczb);

	PiszTablice(tablica_liczb, n);

	Srednia(tablica_liczb, n);

	LiczbaWystapienElementow(tablica_liczb, n);

	LiczbaOrazSumaLiczbNieparzystych(tablica_liczb, n);

	NajmniejszyElement(tablica_liczb, n);

	NajwiekszyElement(tablica_liczb, n);

	NajwiekszaSumaSasiednichPar(tablica_liczb, n);
	
	NajczesciejWystepujacyElement(tablica_liczb, n);

	_getch();
	return EXIT_SUCCESS;
}