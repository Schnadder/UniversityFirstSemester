#include "iostream"

using namespace std;

int main() {
	// char* line = nullptr;   // eller char *line = 0;
	// strcpy(line, "Dette er en tekst");


	char text[5];
	char* pointer = text;
	char search_for = 'e';
	
	cout << "Test";
	
	cin >> text;
	while (*pointer != search_for) {
		cout << "\n a";
		*pointer = search_for;
		pointer++;
	}
	return 0;
}