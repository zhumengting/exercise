package com.zmt.exercise.leetcode.page4;

public class AddValue {
    public static int mySqrt(int x) {
        return compare(0, x, x);
    }

    public static int compare(int before, int end, int target) {
        if (before == end) {
            return before;
        }
        if (end - before == 1) {
            if (end * end == target) {
                return end;
            }
            return before;
        }
        int harf = (end - before) / 2 + before;

        if (harf == target / harf) {
            return harf;
        }
        if (harf > target / harf) {
            end = harf;
        } else {
            before = harf;
        }
        return compare(before, end, target);

    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));

    }
}
