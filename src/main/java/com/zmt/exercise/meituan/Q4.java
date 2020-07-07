package com.zmt.exercise.meituan;

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int k = scanner.nextInt();
        if (s.length() < 2 * k + 1) System.out.println("0");

        int result = 0;
        for (int i = 0; i <= s.length() - 2 * k + 1; i++) {
            for (int j = s.length() - 1; j >= i + 2 * k; j--) {
                if (f(i, j, k, s) != 0) result++;
            }
        }
        System.out.println(result);
    }

    public static int f(int i, int j, int k, String s) {
        String s1 = "";
        String s2 = "";

        for (int t = k; 2 * t + 1 <= j - i + 1; t++) {
            if (t == k) {
                s1 = s.substring(i, i + k);
                s2 = s.substring(j - k + 1, j + 1);
            } else {
                s1 = s1 + s.charAt(i + t - 1);
                s2 = s.charAt(j - t + 1) + s2;
            }
            if(s1.equals(s2)) return t;
        }
        return 0;
    }
}
