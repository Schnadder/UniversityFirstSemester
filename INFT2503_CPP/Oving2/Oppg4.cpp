
#include <iostream>

using namespace std;

int main()
{
	int a = 5;
	int& b = a; // Referansen må referere til en variabel, kan ikke intialiseres uten å referere til noe
	int* c;
	c = &b;
	a = b + *c; // a og b er ikke pointer så det blir feil å bruke *a ettersom dette gir verdien som a peker på
	b = 2; // b er en int ikke en pointer så det gir ikke mening å sette &b lik noe

	cout << "a " << a << "\n";
	cout << "b " << b << "\n";
	cout << "c " << *c << "\n";
	return 0;
}
