#define _USE_MATH_DEFINES

#include <iostream>
#include <conio.h>

using namespace std;

int main(){

	float a, b, r, delta, par_a, par_b, par_c;

	cout << "Podaj dane (a,b,r)" << endl;
	cin >> a;
	cin >> b;
	cin >> r;
	cout << endl;

/*
	y = ax+b
	x2 + y2 = r2;

	x2 + (ax+b)2 = r2

	x2 + a2x2 + 2abx + b2 = r2

	(a2 + 1)x2 + (2ab)x + (b2 - r2) = 0

	delta = (2ab)2 - 4*(a2 + 1)*(b2 - r2)
*/

	par_a = (a*a) + 1;
	par_b = 2*a*b;
	par_c = (b*b) - (r*r);
	delta = (par_b*par_b) - (4 * (par_a*par_c));

	if (delta < 0)
	{
		cout << "Brak punktow wspolnych";
	}
	else if (delta > 0) {
		float x1 = -par_b - sqrt(delta) / (2 * par_a);
		float x2 = -par_b + sqrt(delta) / (2 * par_b);
		float y1 = (par_a * x1) + par_b;
		float y2 = (par_a * x2) + par_b;

		cout << "2 punkt wspolne" << endl;
		cout << "x1 = " << x1 << "\ty1 = " << y1 << endl;
		cout << "x2 = " << x2 << "\ty2 = " << y2 << endl;
	}
	else if (delta == 0) {
		float x = -par_b / 2 * par_a;
		float y = (par_a * x) + par_b;

		cout << "1 punkt wspolny" << endl;
		cout << "x = " << x << "\ty = " << y;
	}
		
	_getch();

	return 0;
}