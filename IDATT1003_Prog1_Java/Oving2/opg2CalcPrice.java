package Oving2;

public class opg2CalcPrice {
    public static void main(String[] args){
        //define variables
        int length = 2;
        double[] resultList = new double[length]; // Creates an arraylist to store the results
        
        double[][] testVars = {randomArray(length), randomArray(length)}; // Calls the randomArray method to create an array of random numbers for testing
        testVars = transposeMatrix(testVars); // transposes the matrix to make it easier to work with

        // Calculate the price per gram for each product in testVars
        for (int i = 0; i < length; i++ ){
            resultList[i] = pricePerGram(testVars[i][0], testVars[i][1]); // Calls the pricePerGram method to calculate the price per gram
        }

        // Print result
        System.out.println("The price per gram for the first product is: " + resultList[0]);
        System.out.println("The price per gram for the second product is: " + resultList[1]);
        if (resultList[0] > resultList[1]){
            System.out.println("The first product is more expensive per gram than the second product");
        }
        else if (resultList[0] < resultList[1]){
            System.out.println("The second product is more expensive per gram than the first product");
        }
        else{
            System.out.println("The products are equally expensive per gram");
        }

    }

    public static double pricePerGram(double weight, double price){
        double pricePerGram = price/weight;
        return pricePerGram;
    }

    public static double[] randomArray(int length){// fills an array of specified length with random numbers between 0 and 10
        double[] randomArray = new double[length];
        for (int i = 0; i < length; i++) {
            randomArray[i] = Math.random()*10; 
        }
        return randomArray;
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
}

