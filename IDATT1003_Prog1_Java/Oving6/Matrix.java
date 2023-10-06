package Oving6;

public final class Matrix {
    private final double matrix[][];

    public Matrix(double[][] inputMatrix){
        this.matrix = inputMatrix;
    }

    public double[][] getTable(){
        return this.matrix;
    }

    public double[][] addMatrix(double[][] inputMatrix){
        int numRows = this.matrix.length;
        int numCols = this.matrix[0].length;
        double[][] outputMatrix = new double[numRows][numCols];
    
        if (numRows == inputMatrix.length && numCols == inputMatrix[0].length){
            for (int row = 0; row < numRows; row++){
                for (int col = 0; col < numCols; col++){
                    outputMatrix[row][col] = this.matrix[row][col] + inputMatrix[row][col];
                }
            }
            return outputMatrix;
        }
        return null; // Returns null if the dimentions match
    }
    
    public double[][] multiplyMatrix(double[][] inputMatrix){
        int numRowsMain = this.matrix.length;
        int numColsMain = this.matrix[0].length; // Cols of main = rows of input
        int numColsInput = inputMatrix[0].length;

        if (numColsMain != inputMatrix.length){
            return null;
        }
        double[][] outputMatrix = new double[numRowsMain][numColsInput];
        double temp;

        for (int row = 0; row < numRowsMain; row++){
            for (int col = 0; col < numColsInput; col++){
                temp = 0;
                for (int i = 0; i < numColsMain; i++){
                    temp += this.matrix[row][i] * inputMatrix[i][col];
                }
                outputMatrix[row][col] = temp;
            }
        }
        return outputMatrix;
    }


    public double[][] transposeMatrix() { // defines a method for transposing a matrix
        int numRows = this.matrix.length;
        int numCols = this.matrix[0].length;

        double[][] transposedMatrix = new double[numCols][numRows];

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                transposedMatrix[col][row] = this.matrix[row][col];
            }
        }
        return transposedMatrix;
    }
}
