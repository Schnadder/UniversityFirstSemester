
#include <iostream>

using namespace std;

int main()
{
	// Defining variables
	int i = 3;
	int j = 5;
	int* p = &i;
	int* q = &j;

	// Changing some variables
	*p = 7; // i = 7
	*q += 4; // j += 4 -> j = 9
	*q = *p + 1; // j = i + 1 -> j = 8
	p = q; // p = q = &j
	cout << *p << " " << *q << endl; // 8 8

	// Printing variables
	cout << "i:" << i << "\n";
	cout << "address to i:" << &i << "\n";
	cout << "j:" << j << "\n";
	cout << "address to j:" << &j << "\n";
	cout << "p:" << p << "\n";
	cout << "address to p:" << &p << "\n";
	cout << "q:" << q << "\n";
	cout << "address to q:" << &q << "\n";

	// It corresponded with my drawings
}

