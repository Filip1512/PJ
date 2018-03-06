/*
Napisz program, który obliczy sume kwadratów liczb od 1 do n. Zastosuj instrukcje petli
for. Wyswietl wynik w postaci:
cout << ”1*1 + 2*2 + ... + n*n” << suma << endl;
*/

#include <iostream>
#include <conio.h>

using namespace std;

int main() {

	int i, iloscSum, sumaKwadratow = 0;

	cout << "Ile sum kwadratow liczb policzyc?" << endl;
	cin >> iloscSum;

	
	for (i = 1; i <= iloscSum; i++) {
		sumaKwadratow += i * i;

		if (i == iloscSum) {
			cout << i << "*" << i;
		}
		else {
			cout << i << "*" << i << " + ";
		}
	}
	cout << " = " << sumaKwadratow;

	_getch();
	return EXIT_SUCCESS;
}