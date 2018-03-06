#define _USE_MATH_DEFINES
#include <iostream>
#include <conio.h>

using namespace std;

int main(){
	int promien;
	double poleKola;

	cout << "Podaj promien kola" << endl;
	cin >> promien;
	
	if(promien <= 0){
		cout << "Promien nie moze byc <= 0" << endl;
		_getch();
		return EXIT_FAILURE;
	}
	else{
		cout << "Policze pole kola" << endl;
	}

	poleKola = M_PI * promien * promien;
	cout << "Pole kola wynosi " << poleKola << endl;

	_getch();
	
	return EXIT_SUCCESS;
}