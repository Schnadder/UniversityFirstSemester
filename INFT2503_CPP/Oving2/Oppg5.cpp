#include <iostream>

using namespace std;

int main()
{
	double number = 0;
	double* pointer = &number;
	double& ref = number;

	// Måter å tilordne en verdi til number:
	// 1:
	number = 1;
	cout << "number: " << number << "\n";

	// 2:
	*pointer = 2;
	cout << "number: " << number << "\n";

	// 3:
	ref = 3;
	cout << "number: " << number << "\n";

	return 0;
}
