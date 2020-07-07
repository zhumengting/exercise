package com.zmt.exercise.leetcode.dp;

public class Q718 {
    public static int findLength(int[] A, int[] B) {
        int[][] result = new int[A.length + 1][B.length + 1];
        int max = 0;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) result[i][j] = result[i - 1][j - 1] + 1;
                max = Math.max(max, result[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1, 0, 0, 0, 1, 0, 0, 1, 0, 0};
        int[] b = {0, 1, 1, 1, 0, 1, 1, 1, 0, 0};
        System.out.println(findLength(a, b));
    }
}
