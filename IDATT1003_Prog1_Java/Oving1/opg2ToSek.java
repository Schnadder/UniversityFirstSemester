package Oving1;
import java.util.ArrayList;

public class opg2ToSek {
    public static void main(String[] args) {
        // Declare variables
        int length = 5;
        double[] testHour = randomArray(length); // Calls the randomArray method to create an array of random numbers for testing
        double[] testMin = randomArray(length);
        double[] testSek = randomArray(length);
        double[][] testVars = {testHour, testMin, testSek}; // Combines the hour, minute and sekond arrays into a 2d array
        double[][] inputVars = transposeMatrix(testVars); // Transposes the 2d array so that the hour, minute and sekond values are in the same array

        ArrayList<Double> resultList = new ArrayList<Double>(); // Creates an arraylist to store the results
        
        // Calculate the time
        for (double[] var : inputVars) { //Iterates through the 2d array
            Double result = timeToSek(var[0], var[1], var[2]); // Calls the timeToSek method to calculate the time in sekonds
            resultList.add(result); // Adds the result to the arraylist
        }
     
        // Print result
        for (double var: resultList){
            System.out.println("The total time in seconds: " + var);
        }




    }

    public static double timeToSek(double hour, double min, double sek){ // defines a method for converting time to seconds
        return hour*3600 + min*60 + sek;
    }

    public static double[][] transposeMatrix(double[][] matrix) { // defines a method for transposing a matrix
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        double[][] transposedMatrix = new double[numCols][numRows];

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                transposedMatrix[col][row] = matrix[row][col];
            }
        }

        return transposedMatrix;
    }

    public static double[] randomArray(int length){// fills an array of specified length with random numbers between 0 and 10
        double[] randomArray = new double[length];
        for (int i = 0; i < length; i++) {
            randomArray[i] = Math.random()*10; 
        }
        return randomArray;
    }
}
