package Oving8;



public class ArbTakerClient {
    public static void main(String[] args){    
        Person testPerson = new Person("Sander", "Nessa", 2003);
        ArbTaker testArbTaker = new ArbTaker(testPerson, 123, 2020, 40_000, 20);
        
        String question1 = "What do you want to change? \n1. set Salary \n2. set TaxPercent \n3. quit \n";
        String question2 = "What is the new number? ";


        // Only checks for ints, error if user gives non integer
        // If given Integer different from 1-3 program just prints info without changing anything
        while(true) {
            System.out.println(testArbTaker.toString());
            int choice = Integer.parseInt(System.console().readLine(question1));
            
            if (choice == 1) {
                double newNum = Double.parseDouble(System.console().readLine(question2));
                testArbTaker.setSalary(newNum);
            }
            else if (choice == 2) {
                double newNum = Double.parseDouble(System.console().readLine(question2));
                testArbTaker.setTaxPercent(newNum);
            }
            else if (choice == 3) {
                break;
            }
        }
    }
}
