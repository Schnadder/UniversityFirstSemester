package Oving6;

import java.util.Arrays;

public class MatrixClient {

    public static void main(String args[]){

        double[][] a = {{4, 3}, {9, 8}, {3, 4}};
        Matrix testMatrix = new Matrix(a);
        Matrix newMatrix = new Matrix(testMatrix.transposeMatrix());

        System.out.println(Arrays.deepToString(testMatrix.getTable()));
        System.out.println(Arrays.deepToString(newMatrix.getTable()));
        System.out.println(Arrays.deepToString(newMatrix.addMatrix(newMatrix.getTable())));
        // 3x3
        System.out.println(Arrays.deepToString(testMatrix.multiplyMatrix(newMatrix.getTable())));

        // 2x2
        System.out.println(Arrays.deepToString(newMatrix.multiplyMatrix(testMatrix.getTable())));
        
        System.out.println(Arrays.deepToString(newMatrix.multiplyMatrix(newMatrix.getTable())));
    
    }
}
