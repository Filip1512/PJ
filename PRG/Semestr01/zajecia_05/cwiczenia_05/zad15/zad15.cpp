#define _USE_MATH_DEFINES

#include <iostream>
#include <conio.h>
#include <math.h>

using namespace std;

int ITERACJE = 0;


int PokazMenu() {
	int wybor;

	cout << "\n\nCo chcesz zrobic?" << endl;
	cout << "1) Policz f(x) = sinx * cosx + 5x + 1" << endl;
	cout << "2) Policz f(x) = ((n - x^2) + sinx) / sqrt(25-x)" << endl;
	cout << "3) Policz f(x) = e^-1.5x - 0.3x^2" << endl;
	cout << "4) Wyjdz z programu\n" << endl;

	cin >> wybor;

	system("cls");
	return wybor;
}

void PobierzDane(double &a, double &b, double &Eps) {
	cout << "Podaj pierwszy kraniec a: ";
	cin >> a;
	cout << "\nPodaj drugi kraniec b: ";
	cin >> b;
	cout << "\nPodaj dokladnosc Eps: ";
	cin >> Eps;
}

double Funkcja(double x, int funkcja) {

	double Fx;

	switch (funkcja) {
	case 1: {Fx = sin(x)*cos(x) + (5 * x) + 1;
		break;}
	case 2: {Fx = (M_PI - (x*x) + sin(x)) / (sqrt(25 - x));
		break;}
	case 3: {Fx = pow(M_E, -1.5 * x) - (0.3*x*x);
		break;}
	default: {Fx = pow(M_E, -1.5 * x) - (0.3*x*x);
		break;}
	}

	return Fx;
}

double Bisekcja(double a, double b, double Eps, int wyborFunkcji) {

	double Fa = Funkcja(a, wyborFunkcji);
	double Fb = Funkcja(b, wyborFunkcji);
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
			double Fc = Funkcja(c, wyborFunkcji);

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
	int wyborZMenu = 1;

	do {
		ITERACJE = 0;

		wyborZMenu = PokazMenu();
		if (wyborZMenu != 4) {

			double a, b, Eps, pierw = 0;
			PobierzDane(a, b, Eps);

			double Fa = Funkcja(a, wyborZMenu);
			double Fb = Funkcja(b, wyborZMenu);

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
				pierw = Bisekcja(a, b, Eps, wyborZMenu);
				cout << "\nWynik: " << pierw << endl;
				cout << "Liczba iteracji: " << ITERACJE;
			}
		}
		else {
			break;
		}

	} while (wyborZMenu != 4);

	return EXIT_SUCCESS;
}