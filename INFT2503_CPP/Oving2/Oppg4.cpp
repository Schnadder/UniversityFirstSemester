
#include <iostream>

using namespace std;

int main()
{
	int a = 5;
	int& b = a; // Referansen m� referere til en variabel, kan ikke intialiseres uten � referere til noe
	int* c;
	c = &b;
	a = b + *c; // a og b er ikke pointer s� det blir feil � bruke *a ettersom dette gir verdien som a peker p�
	b = 2; // b er en int ikke en pointer s� det gir ikke mening � sette &b lik noe

	cout << "a " << a << "\n";
	cout << "b " << b << "\n";
	cout << "c " << *c << "\n";
	return 0;
}
