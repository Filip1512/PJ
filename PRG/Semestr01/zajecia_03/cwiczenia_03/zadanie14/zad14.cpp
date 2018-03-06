#define _USE_MATH_DEFINES

#include <iostream>
#include <conio.h>
#include <math.h>


using namespace std;

int main() {

	int iteracje = 0;
	double a, b, c, Eps, pierw, bezw;

	cout << "Podaj pierwsz kraniec a: ";
	cin >> a;
	cout << "\nPodaj drugi kraniec b: ";
	cin >> b;
	cout << "\nPodaj dokladnosc Eps: ";
	cin >> Eps;

	// f(x) = e^-1,5x - 0,3x^2
	double Fa = pow(M_E, -1.5 * a) - (0.3*a*a);
	double Fb = pow(M_E, -1.5 * b) - (0.3*b*b);

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
			double Fc = pow(M_E, -1.5 * c) - (0.3*c*c);

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
		iteracje++;
	} while (abs(a - b) >= Eps);

	if (abs(a - b) < Eps){
		if (Fa == 0.0) {
			pierw = a;
		}
		else if (Fb == 0.0) {
			pierw = b;
		}
		else {
			pierw = c;
		}
	}

	cout << "\nWynik: " << pierw << endl;
	cout << "Liczba iteracji: " << iteracje;


	_getch();
	return EXIT_SUCCESS;
}