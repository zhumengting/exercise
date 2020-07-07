package com.zmt.exercise.leetcode.leetcode196;

public class Q2 {
    public int numSubmat(int[][] mat) {
        int row = mat.length;
        int column = mat[0].length;
        int[][] rowMatrix = new int[row + 1][column + 1];
        int[][] columnMatrix = new int[row + 1][column + 1];
        int result = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (mat[i - 1][j - 1] == 1) {
                    rowMatrix[i][j] = rowMatrix[i][j - 1] + 1;
                    columnMatrix[i][j] = columnMatrix[i - 1][j] + 1;
                    result += columnMatrix[i][j];
                    int tempJ = j-1;
                    int min = columnMatrix[i][j];
                    while (tempJ > 0 && columnMatrix[i][tempJ] >= 1){
                        min = Math.min(min,columnMatrix[i][tempJ]);
                        result += min;
                        tempJ--;
                    }
                }
            }
        }
        return result;
    }
}
