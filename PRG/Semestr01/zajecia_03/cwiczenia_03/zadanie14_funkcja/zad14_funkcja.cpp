#define _USE_MATH_DEFINES

#include <iostream>
#include <conio.h>
#include <math.h>

using namespace std;

int ITERACJE = 0;

double Funkcja(double x) {

	double Fx = pow(M_E, -1.5 * x) - (0.3*x*x);

	return Fx;
}

double Bisekcja(double a, double b, double Eps) {

	double Fa = Funkcja(a);
	double Fb = Funkcja(b);
	double pierw, c;

	do {
		if (Fa == 0.0) {
			pierw = a;
			break;
		}
		else if (Fb == 0.0) {
			pierw = b;
			break;
		}
		else {
			c = (a + b) / 2.0;
			double Fc = Funkcja(c);

			if (Fc == 0.0) {
				pierw = c;
				break;
			}
			else {
				if (Fa*Fc < 0.0) {
					b = c;
				}
				else {
					a = c;
				}
			}
		}
		pierw = c;
		ITERACJE++;
	} while (abs(a - b) >= Eps);
	return pierw;
}


int main() {
	double a, b, Eps, pierw = 0;

	cout << "Podaj pierwszy kraniec a: ";
	cin >> a;
	cout << "\nPodaj drugi kraniec b: ";
	cin >> b;
	cout << "\nPodaj dokladnosc Eps: ";
	cin >> Eps;

	double Fa = Funkcja(a);
	double Fb = Funkcja(b);

	if (abs(a - b) < Eps) {
		if (Fa == 0.0) {
			cout << "\nWynik: " << a << endl;
			cout << "Liczba iteracji: " << ITERACJE;
		}
		else if (Fb == 0.0) {
			cout << "\nWynik: " << b << endl;
			cout << "Liczba iteracji: " << ITERACJE;
		}
	}
	else {
		pierw = Bisekcja(a, b, Eps);
		cout << "\nWynik: " << pierw << endl;
		cout << "Liczba iteracji: " << ITERACJE;
	}


	_getch();
	return EXIT_SUCCESS;
}