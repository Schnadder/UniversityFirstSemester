#include <iostream>

using namespace std;

int find_sum(const int* table, int length);

int main()
{
	const int length = 20;
	int table[length];

	for (int i = 0; i < length; i++) {
		table[i] = i + 1;
	}

	const int* start = &table[0];
	int sum_start = find_sum(start, 10);
	
	const int* mid = &table[10];
	int sum_mid = find_sum(mid, 5);

	const int* end = &table[15];
	int sum_end = find_sum(end, 5);
	
	cout << "Sum de 10 forste tallene: " << sum_start << "\n";
	cout << "Sum de 5 neste tallene: " << sum_mid << "\n";
	cout << "Sum de 5 siste tallene: " << sum_end << "\n";
	
	return 0;
}

int find_sum(const int* table, int length) {
	int sum = 0;

	for (int i = 0; i < length; i++) {

		sum += table[i];
	}
	return sum;
}