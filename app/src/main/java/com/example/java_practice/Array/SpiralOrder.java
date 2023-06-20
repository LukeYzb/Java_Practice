package com.example.java_practice.Array;

public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, k = 0;
        int[] res = new int[(r + 1) * (b + 1)];

        while (true) {
            //left to right
            for (int i = t, j = l; j <= r; j++) {
                res[k++] = matrix[i][j];
            }
            t++;
            if (t > b) break;
            //top to bottom
            for (int i = t, j = r; i <= b; i++) {
                res[k++] = matrix[i][j];
            }
            r--;
            if (r < l) break;
            //right to left
            for (int i = b, j = r; j >= l; j--) {
                res[k++] = matrix[i][j];
            }
            b--;
            if (b < t) break;
            //bottom to top
            for (int i = b, j = l; i >= t; i--) {
                res[k++] = matrix[i][j];
            }
            l++;
            if (l > r) break;
        }

        return res;
    }
}
