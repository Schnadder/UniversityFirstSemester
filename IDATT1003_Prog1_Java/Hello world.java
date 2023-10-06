import java.util.Arrays;

class helloworld{
    public static void main(String[] args) {
        System.out.println("Hello world");

        double[] testHour ={1, 2, 3.4, 5.6, 7.8, 9.10};
        double[] testMin ={1, 2, 3.4, 5.6, 7.8, 9.10};
        double[] testSek ={1, 2, 3.4, 5.6, 7.8, 9.10};
        double[][] testVars = {testHour, testMin, testSek};

        System.out.println(testVars);
        
        double[][] outputVars = transposeMatrix(testVars);
        System.out.println(Arrays.deepToString(testVars));
        System.out.println(Arrays.deepToString(outputVars));
    }

    public static double[][] transposeMatrix(double[][] matrix) {
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
