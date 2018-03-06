/*Napisz program, który utworzy tablice dwuwymiarowa [A]8x10 sk³adajaca sie z
elementów ca³kowitych z zakresu <1, 10> i zamieni wiersz k-ty z wierszem l-tym.
Elementy tablicy wygeneruj losowo. Indeksy k i l nalezy wczytac z klawiatury.
Wyswietl tablice pierwotna i zmodyfikowana.

W programie nalezy utworzyc funkcje:
void dane(int A[ ][10] );
void pisz_tab( * uzupelnij * );
void zamiana( * uzupelnij *);

*/

#include <iostream>
#include <conio.h>
#include <time.h>
#include <algorithm>

using namespace std;

void WypelnijTablice(int tab[8][10], int w1, int w2) {

	for (int i = 0; i < w1; i++) {
		for (int j = 0; j < w2; j++) {
			tab[i][j] = rand() % 10 + 1;
		}
	}
}

void WypiszTablice(int tab[8][10]) {

	for (int j = 0; j < 10; j++) {
		cout << "\tK" << j;
	}

	cout << "\n\n";

	for (int i = 0; i < 8; i++) {
		cout << "W" << i << "\t";
		for (int j = 0; j < 10; j++) {
			cout << tab[i][j] << "\t";
		}
		cout << endl;
	}

}

void ZmienWiersze(int tab[8][10]) {

	int w1, w2;

	cout << "\n\nPodaj ktore wiersze zamienic miejscami."
		<< "\nWiersz W";
	cin >> w1;
	cout << "Z wierszem W";
	cin >> w2;

	swap(tab[w1], tab[w2]);

	cout << "\n";

}


int main() {

	srand(time(NULL));

	int tablica_liczb[8][10];
	WypelnijTablice(tablica_liczb, 8, 10);

	cout << "Oto tablica wypelniona losowymi liczbami\n\n";
	WypiszTablice(tablica_liczb);

	ZmienWiersze(tablica_liczb);

	cout << "Tablica z zamienionymi wierszami\n\n";
	WypiszTablice(tablica_liczb);

	_getch();
}