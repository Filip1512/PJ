#include <iostream>
#include <conio.h>
#include <time.h>
#include <Windows.h>

using namespace std;

int main() {

	srand(time(NULL));

	cout << "Nacisnij dowolny klawisz, aby rozpoczac pierwszy rzut kostka..." << endl;
	_getch();

	int wyjscie;
	double win;

	do {

		system("cls");

		int p = rand() % 6 + 1;
		int q = rand() % 6 + 1;
		
		cout << "Wylosowane liczby to p = " << p << " oraz q = " << q << endl;
		_getch();

		//parzyste
		if (p % 2 == 0) {
			if (q == 2 || q == 4 || q == 5) {
				win = p + 3 * q;
			}
			if (q == 1 || q == 3 || q == 6) {
				win = 2 * q;
			}
		}

		// nieparzyste
		if (p % 2 != 0) {
			if (q == 1 || q == 3 || q == 6) {
				if (p == q) {
					win = 5 * p + 3;
				}
				if (p != q) {
					win = 2 * q + p;
				}
			}
			if (q == 2 || q == 4 || q == 5){
				win = min(p, q) + 4;
			}
		}

		if (p == 5 && q == 5) {
			win += 5;
		}

		cout << "Twoja wygrana to: " << win << endl;
		cout << "0 - policz jeszcze raz, 1 - zamknij program" << endl;
		cin >> wyjscie;

	} while (wyjscie == 0);

	return 0;
}