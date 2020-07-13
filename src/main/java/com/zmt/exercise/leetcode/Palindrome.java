package com.zmt.exercise.leetcode;

public class Palindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int begin = 0;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();
        while (begin < end) {
            if ((chars[begin] > 'z' || chars[begin] < 'a') && (chars[begin] > '9' || chars[begin] < '0')) {
                begin++;
            } else if ((chars[end] > 'z' || chars[end] < 'a') && (chars[end] > '9' || chars[end] < '0')) {
                end--;
            } else if (chars[begin] == chars[end]) {
                begin++;
                end--;
            } else {
                return false;
            }
        }
        return true;

    }
}
