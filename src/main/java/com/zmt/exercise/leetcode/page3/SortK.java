package com.zmt.exercise.leetcode.page3;

import java.util.ArrayList;
import java.util.List;

public class SortK {
    public static String getPermutation(int n, int k) {
        k = k - 1;
        int divided = 0;
        int mul = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n - 1; i >= 1; i--) {
            mul = NMul(i);
            divided = k / mul;
            k = k % mul;
            stringBuilder.append(list.get(divided));
            list.remove(divided);
        }
        stringBuilder.append(list.get(0));
        return stringBuilder.toString();
    }

    private static int NMul(int n) {
        int val = 1;
        for (int i = n; i >= 1; i--) {
            val *= i;
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
    }
}
