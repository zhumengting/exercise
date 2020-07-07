package com.zmt.exercise.leetcode.dp;

public class NumMatrix {
    int[][] matrix;
    int[][] result;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        if (matrix.length == 0) {
            result = new int[0][0];

        } else {
            result = new int[matrix.length][matrix[0].length];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {

                    result[i][j] += matrix[i][j];
                    if (i >= 1) result[i][j] += result[i - 1][j];
                    if (j >= 1) result[i][j] += result[i][j-1];
                    if (i >= 1 && j >= 1) result[i][j] -= result[i - 1][j - 1];
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }

        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int value = result[row2][col2];
        if (row1 >= 1 && col1 >= 1) value += result[row1 - 1][col1 - 1];
        if(row1 >=1 )value -= result[row1-1][col2];
        if(col1 >=1) value -= result[row2][col1-1];
        return value;
    }
}
