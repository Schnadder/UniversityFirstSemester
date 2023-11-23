package Oving8;

public class ArbTaker {
    private Person person;
    private int employeeNumber;
    private int employmentYear;
    private double salary;
    private double taxPercent;
    
    public ArbTaker(Person person, int employeeNumber, int employmentYear, double salary, double taxPercent) {
        this.person = person;
        this.employeeNumber = employeeNumber;
        this.employmentYear = employmentYear;
        this.salary = salary;
        this.taxPercent = taxPercent;
    }

    public double getTaxAmount() {
        return salary * taxPercent / 100;
    }

    public double getGrossIncome() {
        return salary * 12;
    }

    public double getTaxPerYear() {
        // If taxPercent = trekkprosent
        return getTaxAmount() * 10.5;
        // If taxPercent = skatteprosent
        // return getTaxAmount() * 12;
    }

    public String getName() {
        return person.getLastName() + ", " + person.getFirstName();
    }

    public int getAge() {
        // Why not this approach, compared to the hint
        int currentYear = java.time.Year.now().getValue();
        return currentYear - person.getBirthYear();
    }

    public int getEmploymentLength() {
        int currentYear = java.time.Year.now().getValue();
        return currentYear - employmentYear;
    }

    public boolean employedLongerThan(int limit) {
        if (getEmploymentLength() > limit) {
            return true;
        }
        return false;
    }

    public Person getPerson() {
        return person;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public int getEmploymentYear() {
        return employmentYear;
    }

    public double getSalary() {
        return salary;
    }

    public double getTaxPercent() {
        return taxPercent;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setTaxPercent(double taxPercent) {
        this.taxPercent = taxPercent;
    }

    @Override
    public String toString() {
        String output = "";
        output += "Name: " + getName() + "\n";
        output += "Age: " + getAge() + "\n";
        output += "Years employed: " + getEmploymentLength() + "\n";
        output += "Employee number: " + getEmployeeNumber() + "\n";
        output += "Year employed: " + getEmploymentYear() + "\n";
        output += "Montly salary: " + getSalary() + "\n";
        output += "Tax percent: " + getTaxPercent() + "\n";
        output += "Gross salary per year: " + getGrossIncome() + "\n";
        output += "Tax paid per month: " + getTaxAmount() + "\n";
        output += "Tax paid per year: " + getTaxPerYear() + "\n";
        
        return output;
    }
    
    
}
