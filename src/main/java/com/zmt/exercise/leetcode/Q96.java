package com.zmt.exercise.leetcode;


public class Q96 {
    public static void main(String[] args) {
        long a = 123456;
        double b = a;
        while (b > 1024) {
            b = b / 1024;
        }
        System.out.println(b);
    }

    public static int numTrees(int n) {
        int[] count = new int[n + 1];
        if (n == 0) return 0;
        if (n == 1) return 1;
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                count[i] += count[j] * count[i - j - 1];
            }

        }
        return count[n];

    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s1.length() == 0 || s2.length() == 0 || s3.length() == 0) {
            if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) return true;
            if (s3.length() == 0) return false;
            if (s3.equals(s2) || s3.equals(s1)) return true;
            return false;
        }
        boolean[][][] result = new boolean[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        result[0][0][0] = true;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s3.charAt(i)) {
                result[i + 1][0][i + 1] = true;
            } else {
                break;
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == s3.charAt(i)) {
                result[0][i + 1][i + 1] = true;
            } else {
                break;
            }
        }
        for (int i = 2; i <= s3.length(); i++) {
            for (int j = 1; j < i; j++) {
                if (j > s1.length() || i - j > s2.length()) {
                    continue;
                }
                result[j][i - j][i] = (result[j - 1][i - j][i - 1] && s3.charAt(i - 1) == s1.charAt(j - 1)) ||
                        (result[j][i - j - 1][i - 1] && s3.charAt(i - 1) == s2.charAt(i - j - 1));
            }
        }
        return result[s1.length()][s2.length()][s3.length()];

    }
}
