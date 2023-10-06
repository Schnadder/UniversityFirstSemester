package Oving3;

public class opg2PrimeNumbers {
    public static void main(String[] args) {
        // Declare variables
        boolean result;
        int userInput;
        boolean repeat = false;
        String ask;

        do {
            // User input
            try {
                userInput = Integer.parseInt(System.console().readLine("Input a number to check if it is a prime: "));

                // Calculate
                result = isPrime(userInput);

                // Print
                System.out.println(userInput + " is a prime: " + result);
                
                
                // Ask user if the program should repeat
                do{
                    ask = System.console().readLine("Do you want to check a new number? y/n \n");
                    if (ask.equalsIgnoreCase("y")){
                        repeat = true;
                        break;
                    }
                    else if (ask.equalsIgnoreCase("n")){
                        repeat = false;
                        break;
                    }
                    else{
                        System.out.println("Input not recognized please answer: y or n");
                    }
                } while(true);
            }

            catch(NumberFormatException e){ // In this program this happens if the user inputs something other than an int
                System.out.println("Please provide an integer");
                repeat = true;
            }
            catch (Exception e) { // Catches other exceptions, should never happen here
                repeat = true;
                System.out.println("Something went wrong");
            }
        } while(repeat);
    }
    public static boolean isPrime(int num){
        if (num <= 1) { // Returns false if number is equal or less than 1
            return false;
        }

        // Loops through every number from 2 to num/2 because num divided by a number higher than half will never give a natural number
        for (int i = 2; i <= num / 2; i++){ 
            if (num % i == 0){ // Not a prime if there is no remainder
                return false;
            }
        }

        // Is a prime if it passes all the tests
        return true;
    }
}
