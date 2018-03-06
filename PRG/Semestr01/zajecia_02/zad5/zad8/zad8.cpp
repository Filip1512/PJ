#include <iostream>
#include <conio.h>

using namespace std;

int main() {

	int a, b;

	cout << "Podaj liczby, a wskaze Ci ich najwiekszy wspolny dzielnik (A&B E C+)" << endl;
	cin >> a;
	cin >> b;

	do
	{
		if (a > b) {
			a = a - b;
		}
		else {
			b = b - a;
		}
	} while (a != b);

	cout << "Najwiekszy wspolny dzielnik wynosi: " << a << endl;

	_getch();
	return EXIT_SUCCESS;
}