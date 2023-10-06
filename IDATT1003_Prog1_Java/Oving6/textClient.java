package Oving6;

// Could add more exception handeling see commments below for examples
public class textClient {
    
        public static void main(String[] args){        
        
        boolean repeat = true;
        char letter;
        do{
            String input = System.console().readLine("Enter a string you want analysed: ");
            textAnalysis analysis = new textAnalysis(input);

            String letterinput = System.console().readLine("What letter do you want to check for: ");

            // Could add exception handeling and ask user for new char if not a letter
            if (letterinput.length() >= 0){
                letter = letterinput.charAt(0);
            }
            else {
                letter = 'A';
            }

            // Could add exception handeling when calling functions, mainly .count()
            System.out.println("Amount of different letters: " + analysis.different());
            System.out.println("Total amount of letters: " + analysis.amount());
            System.out.println("Percentage of text that isn't letters: " + analysis.notLetter());
            System.out.println("Amount of " + String.valueOf(letter) + ": " + analysis.count(letter));
            System.out.println("The most common letter/letters: " + analysis.mostCommon());




            // Could force user to enter either y or n, now it continues if not y/Y
            String quit = System.console().readLine("Do you want to quit? y/n: ");
            if ("Y".equals(quit.toUpperCase())){
                repeat = false;
            }

        }
        while (repeat);
    
    }
}
