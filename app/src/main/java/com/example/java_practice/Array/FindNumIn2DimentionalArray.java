package com.example.java_practice.Array;

public class FindNumIn2DimentionalArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //empty matrix
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return false;
        }

        int cols = matrix.length;
        int rows = matrix[0].length;

        int col = cols - 1;
        int row = 0;

        while (col >= 0 && row < rows) {
            if (target > matrix[col][row]) {
                row++;
            } else if (target < matrix[col][row]) {
                col--;
            } else {
                return true;
            }
        }

        return false;
    }
}
