package com.zmt.exercise.leetcode;

public class Q132 {
    public int minCut(String s) {
        if (s.length() == 0 || s.length() == 1) return 0;

        boolean[][] matrix = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            matrix[i][i] = true;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) matrix[i][i - 1] = true;
        }
        int min = 0;
        int[] mincat = new int[s.length() + 1];
        mincat[0] = 0;
        for (int i = 0; i < s.length(); i++) {
            min = i + 1;
            for (int j = 0; j <= i; j++) {
                if (j < i - 1 && s.charAt(i) == s.charAt(j) && matrix[i - 1][j + 1]) {
                    matrix[i][j] = true;
                }
                if (matrix[i][j]) {
                    if(j == 0) min = 0;
                    else min = Math.min(min, 1 + mincat[j]);
                }
            }
            mincat[i + 1] = min;

        }
        return mincat[s.length()];

    }
}
