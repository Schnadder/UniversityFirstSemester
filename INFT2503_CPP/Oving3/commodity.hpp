#include <iostream>

using namespace std;

const double sales_tax = 0.25;

class Commodity {
public:
	Commodity(const string& name_, int id_, double price_);
	string get_name() const;
	int get_id() const;
	double get_price(double quantity_) const;
	void set_price(double price_);
	double get_price_with_sales_tax(double quantity_) const;

private:
	string name;
	int id;
	double price;
};

Commodity::Commodity(const string& name_, int id_, double price_)
	: name(name_), id(id_), price(price_) {}

string Commodity::get_name() const {
	return name;
}

int Commodity::get_id() const {
	return id;
}

double Commodity::get_price(double quantity_ = 1) const {
	return price * quantity_;
}

void Commodity::set_price(double price_) {
	price = price_;
}

double Commodity::get_price_with_sales_tax(double quantity_) const {
	double price_without = get_price(quantity_);
	return price_without + price_without * sales_tax;
}