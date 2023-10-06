package Oving6;
import java.util.Random;

public class opg1 {
    public static void main(String args[]){

        Random random = new Random();
        int n = 1000;
        int bound = 10;
        int num;
        int amount[] = new int[bound];

        for (int i = 0; i < n; i++){
            num = random.nextInt(bound);
            amount[num]++;
        }

        // Printing
        for (int i = 0; i < bound; i++){
            // Always rounds down
            System.out.println(String.format("%s: %s %s", i, amount[i], "*".repeat(amount[i] / (n/100)))); 
        }
    }
    
}
