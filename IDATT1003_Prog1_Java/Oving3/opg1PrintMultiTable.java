package Oving3;

public class opg1PrintMultiTable{
    public static void main(String[] args) {
        // Declare variables
        int inputStart;
        int inputEnd;
        String result;
        boolean repeat = false;

        // User Input
        do {
            inputStart = Integer.parseInt(System.console().readLine("Enter the start of the multiplication table: "));
            inputEnd = Integer.parseInt(System.console().readLine("Enter the end of the multiplication table: "));
            if (inputStart > inputEnd){
                System.out.println("The end must be equal or bigger than the start");
                repeat = true;
            }

            else {
                repeat = false;
            }
        } while(repeat);
        // Calculate
        result = printMultiTable(inputStart, inputEnd);

        // Print result
        System.out.println(result);
    }
    public static String printMultiTable(int start, int end){ // Returns a string of multiplikasjon table ready to be printed
        String result = "";
        int newResult;
        
        for (int i = start; i <= end; i++){ //looping from start to end
            
            result += String.format("%s-gangen:\n",i);
            for (int num = 1; num <= 10; num ++){ // Looping from 1 to 10
                newResult = num*i;
                result += String.format("%s x %s = %s\n",i, num, newResult);
                
            }
        }
        return result;
    }
    
}