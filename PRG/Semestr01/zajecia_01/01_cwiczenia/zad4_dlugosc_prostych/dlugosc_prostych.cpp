#include <iostream>
#include <conio.h>

using namespace std;

int main() {

	int a, b, c;

	cout << "Podaj rozne dlugosci prostych (a,b,c)" << endl << "a: ";
	cin >> a;
	cout << "b: ";
	cin >> b;
	cout << "c: ";
	cin >> c;

	if (a < b && a < c) {
		cout << "Najkrotszy odcinek to a = " << a;
	}
	else if (b < a && b < c) {
		cout << "Najkrotszy odcinek to b = " << b;
	}
	else if (c < a && c < b) {
		cout << "Najkrotszy odcinek to c = " << c;
	}
	else {
		cout << "Niepoprawne dane";
	}

	_getch();

	return EXIT_SUCCESS;
}