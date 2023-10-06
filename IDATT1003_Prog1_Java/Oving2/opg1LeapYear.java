package Oving2;
import java.io.Console;

public class opg1LeapYear {
    public static void main(String[] args) {
        // Declare variables
        int testYear;
        boolean result;
        Console console = System.console();

        //Get user inputs
        testYear = Integer.parseInt(console.readLine("Enter a year: "));

        // Calculate 
        result = isLeapYear(testYear);

        // Print result
        if (result){
            System.out.println(testYear + " is a leap year");
        }
        else{
            System.out.println(testYear + " is not a leap year");
        }

    }
    
    public static boolean isLeapYear(int year){ // checks if a year is a leap year
        if (year % 4 == 0){
            if (year % 100 == 0){
                if (year % 400 == 0){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }

    }
}