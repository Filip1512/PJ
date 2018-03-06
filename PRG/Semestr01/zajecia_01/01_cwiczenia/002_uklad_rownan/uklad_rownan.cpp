#define _USE_MATH_DEFINES
#include <iostream>
#include <conio.h>

using namespace std;

int main(){
	int a,b,c,d,e,f,W,Wx,Wy;

	float x,y;

	cout << "Podaj dane (a,b,c,d,e,f): " << endl;
	cin >> a;
	cin >> b;
	cin >> c;
	cin >> d;
	cin >> e;
	cin >> f;

	W = a*d - c*b;
	Wx = e*d - f*b;
	Wy = a*f - c*e;

	if (W != 0){
		
		x = Wx/W;
		y = Wy/W;

		cout << "x = " << x << endl;
		cout << "y = " << y << endl;

	}

	if (W == 0 && (Wx != 0 || Wy != 0)){
		cout << "Brak rozwiazan, uklad sprzeczny" << endl;
	}

	if (W == 0 && Wx == 0 && Wy == 0){
		cout << "Nieskonczenie wiele rozwiazan" << endl;
	}

	_getch();
	return EXIT_SUCCESS;
}