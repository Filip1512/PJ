#include <iostream>
#include <math.h>
#include <conio.h>

using namespace std;

int main() {
	int n, k, m = 0;
	cout << "Podaj liczbe elementow zbioru n: ";
	cin >> n;
	cout << "\nPodaj liczbe elementow podzbioru k: ";
	cin >> k;


	int n_silnia = 1;
	for (int i = 1; i <= n; i++) {
		n_silnia *= i;
	}

	int k_silnia = 1;
	for (int i = 1; i <= k; i++) {
		k_silnia *= i;
	}

	int nk_silnia = 1;
	for (int i = 1; i <= n - k; i++) {
		nk_silnia *= i;
	}

	cout << "\nn = " << n;
	cout << "\nk = " << k;
	cout << "\nn_silnia = " << n_silnia;
	cout << "\nk_silnia = " << k_silnia;
	cout << "\nnk_silnia = " << nk_silnia;
	cout << "\nPolicz: (n_silnia) / (k_silnia * nk_silnia)" << endl;

	m = (n_silnia) / (k_silnia*nk_silnia);
	cout << "\n\nWynik: " << m;

	_getch();
}