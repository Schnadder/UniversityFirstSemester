#include <iostream>
#include <cstdlib>
#include <fstream>
#include <filesystem>

using namespace std;
void read_temperatures(double temperatures[], int length);

int main() {

	// Define variables
	const int length = 5;
	const int lower = 10;
	const int higher = 20;

	int under = 0;
	int between = 0;
	int over = 0;
	double var;

	double temperatures[length];
	read_temperatures(temperatures, length);

	for (int i = 0; i < 5; i++) {
		var = temperatures[i];
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


void read_temperatures(double temperatures[], int length) {
	// Opening the file, think it would be better to pass filename as an input, the opg doesn't allow it
	// Works with C:\\Users\\03sas\\OneDrive\\Universitet\\INFT2503\\testing\\Oving1main\\Oving1\\temps.txt
	const char* filename = TEMPS_FILE_PATH;
	ifstream file;
	file.open(filename);
	if (!file) {
		cout << "Could not open file\n";
		exit(EXIT_FAILURE);
	}
	for (int i = 0; i < length; i++) {
		file >> temperatures[i];
	}
	file.close();
}