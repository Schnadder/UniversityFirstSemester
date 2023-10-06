package Oving1;
import java.util.ArrayList;

public class opg1InchToCm {
    public static void main(String[] args) {
        // Declare variables
        double[] testVars ={1, 2, 3.4, 5.6, 7.8, 9.10};
        double inchToCm = 2.54; // 1 inch = 2.54 cm
        ArrayList<Double> resultList = new ArrayList<Double>();
        

        // Calculate area
        for (double var : testVars) {
            Double result = var * inchToCm;
            resultList.add(result);
        }
        // Print result
        System.out.println(resultList);
    }
}
