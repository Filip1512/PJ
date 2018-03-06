#include <iostream>
#include <math.h>
#include <conio.h>

using namespace std;

int main() {

	const int SIZE = 100000;						// rozmiar tablicy 
	bool liczby[SIZE + 1];							// bo zaczyna sie od tab [0], wiec dajemy +1  zeby bylo 100 000 a nie 99 9999,

	for (int i = 1; i <= SIZE; i++) {				// nadaje wszystkim elementom tablicy wartosci TRUE
		liczby[i] = true;
	}

	liczby[1] = false;								// 1 nie jest liczba pierwsza, wiec od razu nadaje wartosc false
	for (int i = 2; i <= sqrt(SIZE); i++) {			// zaczynam od 2, koncze na pierwiastku z SIZE (czyli pierwiastek z tab[100000] = 100000))
		if (liczby[i] == true) {					// jesli liczba z tablicy jest true (nie zostala jeszcze "skreslona"/zmieniona na false)...
			for (int j = 2 * i; j <= SIZE; j += i)	// ... wykonuj sito -> skreslaj wielokrotnosci liczby "i" (2*2, 2*3, ...,2*i, 3*2, 3*3, ..., 3*i)...
			{
				liczby[j] = false;					// ...a skreslonym liczbom nadaj wartosc FALSE
			}
		}
	}

	int przedzial = 1;								// ile liczb sprawdzic (nadaje wartosc, zeby petla zadzialala)
	while (przedzial < 2) {
		system("cls");
		cout << "Podaj do jakiej liczby wypisac liczby pierwsze: ";
		cin >> przedzial;
		cout << "\n\n";
	}

	for (int i = 2; i <= przedzial; i++) {			// dla i = 2, rob i++ co petle, dopoki i < przedzial 

		if (liczby[i] == true) {						// jesli tab[i] jest true, wypisz liczbe elementu tablicy 'i'
			cout << i << ", ";
		}
		else {										// jesli inaczej, to pomin obecna petle
			continue;
		}
	}

	_getch();
	return EXIT_SUCCESS;
}