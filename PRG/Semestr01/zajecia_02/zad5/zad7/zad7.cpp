#include <iostream>
#include <conio.h>

using namespace std;

int main() {

	int a, b, iloczyn, nww = 0;

	cout << "Podaj liczby, a wskaze Ci ich najmniejsza wspolna wielokrotnosc (A&B E C+)"<<endl;
	cin >> a;
	cin >> b;

	iloczyn = a * b;

	do
	{
		if (a > b) {
			a = a - b;
		}
		else {
			b = b - a;
		}
	} while (a != b);

	nww = iloczyn / a;

	cout << "Najmniejsza wspolna wielokrotnosc wynosi: " << nww;

	_getch();
	return EXIT_SUCCESS;
}