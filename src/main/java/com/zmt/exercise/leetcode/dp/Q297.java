package com.zmt.exercise.leetcode.dp;

public class Q297 {
    public int numSquares(int n) {
        int size = 0;
        while (n >= (int) Math.pow(size, 2)) {
            size++;
        }
        if (size == 0 || size == 1) return 0;
        if (size == 2) return n;
        int[] result = new int[n + 1];
        for (int i = 0; i < n + 1; i++) result[i] = i;

        for (int i = 2; i < size; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (j >= (int) Math.pow(i, 2)) {
                    result[j] = Math.min(result[j - (int) Math.pow(i, 2)] + 1, result[j]);
                }
            }
        }
        return result[n];
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(10, 9));
    }

    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        int[] value = {10, 9 * 8, 9 * 9 * 8, 9 * 9 * 8 * 7, 9 * 9 * 8 * 7 * 6, 9 * 9 * 8 * 7 * 6 * 5, 9 * 9 * 8 * 7 * 6 * 5 * 4, 9 * 9 * 8 * 7 * 6 * 5 * 4 * 3,
                9 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2, 9 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2};
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += value[i - 1];
            if (i >= 10) break;
        }
        return result;

    }
}
