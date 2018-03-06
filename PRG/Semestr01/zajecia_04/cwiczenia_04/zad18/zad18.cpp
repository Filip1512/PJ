#include <iostream>
#include <conio.h>
#include <time.h>

using namespace std;

void CzytajDane(int &n, int rozmiar_tablicy, int X[], int Y[]) {

	do {
		cout << "Podaj n (1-10): ";
		cin >> n;

		if (n < 1 || n > rozmiar_tablicy) {
			cout << "Podaj liczbe z przedzialu 1-10!\n";
			_getch();
			system("cls");
		}

	} while (n < 1 || n > rozmiar_tablicy);

	cout << "\nn = " << n << "\n\n";

	//wypelnienie tablic
	for (int i = 0; i < n; i++) {
		X[i] = rand() % 10 + 1;
		Y[i] = rand() % 10 + 1;
	}
	for (int i = n; i < rozmiar_tablicy; i++) {
		X[i] = 0;
		Y[i] = 0;
	}
	// koniec

	cout << "Obecna tablica wektorow: \n\n";
	for (int i = 0; i < rozmiar_tablicy; i++) {
		cout << "X[" << i << "]=" << X[i] << "\t";
		cout << "Y[" << i << "]=" << Y[i] << "\n";
	}
}

int IloczynSkalarny(int n, int X[], int Y[]) {

	int Suma = 0;

	for (int i = 0; i < n; i++) {
		Suma += X[i] * Y[i];
	}

	cout << "\n\nSuma ";
	for (int i = 0; i < n; i++) {
		if (i == n - 1) {
			cout << "X[" << i << "]*Y[" << i << "]";
		}
		else {
			cout << "X[" << i << "]*Y[" << i << "] + ";
		}
	}
	cout << " = ";

	return Suma;
}

int main() {

	srand(time(NULL));
	const int ROZMIAR_TABLICY = 10;
	int n;
	int X[ROZMIAR_TABLICY], Y[ROZMIAR_TABLICY];
	
	CzytajDane(n, ROZMIAR_TABLICY, X, Y);

	int Suma = IloczynSkalarny(n, X, Y);

	cout << Suma;

	_getch();
	return EXIT_SUCCESS;
}