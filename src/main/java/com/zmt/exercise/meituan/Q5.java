package com.zmt.exercise.meituan;

import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] value = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            value[i] = scanner.nextInt();
            max = Math.max(value[i], max);
        }
        boolean[] result = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n && !result[i]; j++) {
                if (Integer.bitCount(value[i] & value[j]) == 0) {
                    result[i] = true;
                    result[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (result[i]) System.out.printf("1 ");
            else System.out.printf("-1 ");
        }

    }
}
