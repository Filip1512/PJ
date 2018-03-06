#define _USE_MATH_DEFINES
#include <iostream>
#include <conio.h>
#include <math.h>

using namespace std;

int main(){

	double poleWycinka, promien, kat, rad_kat;

	cout << "Podaj promien" << endl;
	cin >> promien;
	cout << "Podaj kat (w stopniach)" << endl;
	cin >> kat;
	
	rad_kat = (M_PI*kat)/180;

	poleWycinka = ((promien*promien)/2)*((M_PI*kat/180)-sin(rad_kat));

	cout << "Pole wycinka jest rowne: " << poleWycinka << endl;

	_getch();

	return 0;
}