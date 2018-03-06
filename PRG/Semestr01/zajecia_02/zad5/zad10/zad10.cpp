#include <iostream>
#include <conio.h>

using namespace std;

int main() {

	int kategoria = 0, przepracowane_godziny = 0, stawka = 0, wyjscie = 0;
	double zarobki;

	do {
		
		system("cls");

		cout << "Podaj kategorie zaszeregowania 1 (A), 2 (B), 3 (C), 4 (D): " << endl;
		cin >> kategoria;
		cout << "Podaj ilosc przepracowanych godzin w tygodniu: " << endl;
		cin >> przepracowane_godziny;

		switch (kategoria) {
		case 1:
			stawka = 15;
			break;
		case 2:
			stawka = 25;
			break;
		case 3:
			stawka = 30;
			break;
		case 4:
			stawka = 35;
			break;
		default:
			cout << "Podaj 1 (A), 2 (B), 3 (C) lub 4 (D)!" << endl;
			stawka = 0;
			break;
		}
		
		if (przepracowane_godziny <= 40) {
			
			zarobki = stawka * przepracowane_godziny;

			if (zarobki <= 700) {
				zarobki *= 0.85;
			}
			else if (zarobki > 700 || zarobki <= 1200) {
				zarobki *= 0.8;
			}
			else if (zarobki > 1200) {
				zarobki *= 0.75;
			}
		}
		else if (przepracowane_godziny > 40) {

			zarobki = (stawka * przepracowane_godziny) + (2 * stawka * (przepracowane_godziny - 40));

			if (zarobki <= 700) {
				zarobki *= 0.85;
			}
			else if (zarobki > 700 && zarobki <= 1200) {
				zarobki *= 0.8;
			}
			else if (zarobki > 1200) {
				zarobki *= 0.75;
			}
		}

		cout << "Twoje zarobki to: " << zarobki << endl;
		cout << "0 - policz jeszcze raz, 1 - zamknij program" << endl;
		cin >> wyjscie;

	} while (wyjscie == 0);


	return EXIT_SUCCESS;
}