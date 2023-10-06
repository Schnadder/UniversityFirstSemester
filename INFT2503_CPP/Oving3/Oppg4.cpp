#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main()
{
	// Variables
	string word1;
	string word2;
	string word3;

	// User inputs
	cout << "Enter word1: ";
	cin >> word1;
	cout << " \nEnter word2: ";
	cin >> word2;
	cout << " \nEnter word3: ";
	cin >> word3;

	//word1 = "er aer";
	//word2 = "Sandvik";
	//word3 = "Nessa";

	// Outputs
	string sentence = word1 + " " + word2 + " " + word3 + ".";
	cout << sentence << "\n";
	cout << "Word1 length: " << word1.length() << "\n";
	cout << "Word2 length: " << word2.length() << "\n";
	cout << "Word3 length: " << word3.length() << "\n";
	cout << "Sentence length: " << sentence.length() << "\n";

	string sentence2 = sentence;

	for (int i = 10; i < sentence2.length(); i++) {
		if (i >= 10 && i <= 12) {
			sentence2[i] = 'x';
		}
	}

	cout << "Sentence: " << sentence << "\n";
	cout << "Sentence2: " << sentence2 << "\n";

	string sentence_start = sentence.substr(0, 5);
	cout << "Sentence: " << sentence << "\n";
	cout << "Sentence_start: " << sentence_start << "\n";
	

	string target = "hello";
	size_t pos = sentence.find(target);
	string find_output;
	if (pos > sentence.length()) {
		find_output = target + " is in the sentence";
	}
	else {
		find_output = target + " is not in the sentence";
	}

	cout << find_output << "\n";

	string target2 = "er";

	
	vector<size_t> positions; // Posistions of occurance 
	size_t pos2 = sentence.find(target2);
	while (pos2 < sentence.length()) {
		positions.push_back(pos2);
		pos2 = sentence.find(target2, pos2 + 1);
	}


	for (size_t i = 0; i < positions.size(); ++i) {
		cout << "Position " << i + 1 << " of " << target2 << " :" << positions[i] << endl;
	}

}
