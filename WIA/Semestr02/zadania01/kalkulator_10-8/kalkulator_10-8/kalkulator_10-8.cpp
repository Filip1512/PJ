#include <iostream>

using namespace std;

void Kalkulator(int system10) {

	int system8[10], i = 0;

	while (system10){
		system8[i++] = system10 % 8;
		system10 /= 8;
	}

	for (int j = i - 1; j >= 0; j--) { cout << system8[j]; };
}

int main() {

	int liczba;
	cout << "Podaj liczbe w systemie dziesietnym: ";
	cin >> liczba;
	cout << "Liczba " << liczba << " zapisana w systemie osemkowym jest rowna ";
	Kalkulator(liczba);
	cout << endl;

	system("pause");
	return EXIT_SUCCESS;
}