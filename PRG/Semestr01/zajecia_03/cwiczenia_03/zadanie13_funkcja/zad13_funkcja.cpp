#include <iostream>
#include <math.h>
#include <conio.h>

using namespace std;

int PoliczSilnie(int silnia) {

	int policzona_silnia = 1;
	for (int i = 1; i <= silnia; i++) {
		policzona_silnia *= i;
	}

	return policzona_silnia;
}

int WypiszWynik(int n_silnia, int k_silnia, int nk_silnia) {

	int wynik = (n_silnia) / (k_silnia*nk_silnia);
	cout << "\n\nWynik: " << wynik;
	return EXIT_SUCCESS;
}

int main() {
	int n, k;
	cout << "Podaj liczbe elementow zbioru n: " << endl;
	cin >> n;
	cout << "Podaj liczbe elementow podzbioru k: " << endl;
	cin >> k;

	int n_silnia = PoliczSilnie(n);
	int k_silnia = PoliczSilnie(k);
	int nk_silnia = PoliczSilnie(n - k);

	cout << "\nn = " << n;
	cout << "\nk = " << k;
	cout << "\nn_silnia = " << n_silnia;
	cout << "\nk_silnia = " << k_silnia;
	cout << "\nnk_silnia = " << nk_silnia;
	cout << "\nPolicz: (n_silnia) / (k_silnia * nk_silnia)" << endl;

	WypiszWynik(n_silnia, k_silnia, nk_silnia);

	_getch();
	return EXIT_SUCCESS;
}