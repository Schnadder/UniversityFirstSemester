#include "iostream"

using namespace std;

int main()
{
	// Define variables
	const int length = 5;
	const int lower = 10;
	const int higher = 20;

	int under = 0;
	int between = 0;
	int over = 0;
	double var;

	for (int i = 1; i <= 5; i++) {
		cout << "Temperatur nr " << i << ": ";
		cin >> var;
		if (var < lower) {
			under++;
		}
		else if (var > higher) {
			over++;
		}
		else {
			between++;
		}
	}
	cout << "Antall under 10 er " << under;
	cout << "\nAntall mellom 10 og 20 er " << between;
	cout << "\nAntall over 20 er " << over;
	return 0;
}
