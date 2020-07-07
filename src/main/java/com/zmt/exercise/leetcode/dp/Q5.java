package com.zmt.exercise.leetcode.dp;

public class Q5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaa"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        int begin = 0, end = 0;
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                if (end - begin == 0) {
                    begin = i;
                    end = i + 1;
                }
                isPalindrome[i][i + 1] = true;
            }
        }

        for (int j = 2; j < s.length(); j++) {
            for (int i = 0; i < s.length() - j; i++) {
                if (s.charAt(i) == s.charAt(i + j) && isPalindrome[i + 1][i + j - 1]) {
                    isPalindrome[i][i + j] = true;
                    if (end - begin < j) {
                        begin = i;
                        end = i + j;
                    }
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = begin; i <= end; i++) {
            stringBuilder.append(s.charAt(i));
        }

        return stringBuilder.toString();
    }
}
