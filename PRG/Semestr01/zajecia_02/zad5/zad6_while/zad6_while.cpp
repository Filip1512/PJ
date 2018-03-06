/*
Napisz program, który wyznacza i wyswietla wszystkie dzielniki liczby ca³kowitej n.
Do obliczen wykorzystaj trzy róne instrukcje petli: while, do…while i for.

W celu okreslenia, czy b jest dzielnikiem a, wykorzystaj operacje modulo % (reszta z
dzielenia). Jeeli wynikiem operacji modulo: a % b jest 0, oznacza to, e b jest
dzielnikiem a.
*/


#include <iostream>
#include <conio.h>

using namespace std;

int main() {

	int i, liczba, dzielnik;

	cout << "Podaj liczbe, a podam Ci jej dzielniki" << endl;
	cin >> liczba;

	i = 0;
	while (i <= liczba){
		
		i++;

		if (liczba % i == 0) {
			if (i == liczba) {
				dzielnik = liczba / i;
				cout << dzielnik;
			}
			else if (i != liczba) {
				dzielnik = liczba / i;
				cout << dzielnik << ", ";
			}
		}
		else if (liczba % i != 0) {
			continue;
		}
	}


	_getch();
	return 0;
}