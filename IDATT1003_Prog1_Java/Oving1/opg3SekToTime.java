package Oving1;

public class opg3SekToTime {
    public static void main(String[] args) {
        // Declare variables
        int length = 5;
        double[] inputVars = randomArray(length); // Calls the randomArray method to create an array of random numbers for testing
        
 
        double[][] resultList = new double[length][3]; // Creates an arraylist to store the results
        
        // Calculate the time
        int i = 0; // Counter for the arraylist
        for (double var : inputVars) { //Iterates through the 2d array
            double[] result = secToTime(var); // Calls the timeToSec method to calculate the time in seconds

            resultList[i] = (result); // Adds the result to the arraylist
            i++; // Increments the counter
        }
     
        // Print result
        for (double[] var: resultList){
            System.out.println("Timer: " + var[0] + " Minutter: " + var[1] + " Sekunder: " + var[2]);
        }




    }

    public static double[] secToTime(double sec){ // defines a method for converting time to seconds
        double[] outputVars = new double[3];
        int hour = (int) sec/3600;
        int minutes = (int) (sec - hour*3600)/60;
        int seconds = (int) sec - hour*3600 - minutes*60;
        outputVars[0] = hour;
        outputVars[1] = minutes;
        outputVars[2] = seconds;

        return outputVars;
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
            randomArray[i] = Math.random()*100000; 
        }
        return randomArray;
    }
}
