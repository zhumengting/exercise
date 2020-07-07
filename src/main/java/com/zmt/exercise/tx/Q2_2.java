package com.zmt.exercise.tx;

import java.util.Scanner;

public class Q2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int couple = scanner.nextInt();
        for (int i = 0; i < couple; i++) {
            int size = scanner.nextInt();
            int[][] val1 = new int[size][2];
            for (int j = 0; j < size; j++) {
                val1[i][0] = scanner.nextInt();
                val1[i][1] = scanner.nextInt();
            }
            int[][] val2 = new int[size][2];
            for (int j = 0; j < size; j++) {
                val2[i][0] = scanner.nextInt();
                val2[i][1] = scanner.nextInt();
            }
            double result = Double.MAX_VALUE;
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    result = Math.min(result, Math.sqrt(Math.pow(val1[i][0] - val2[j][0], 2) + Math.pow(val1[i][1] - val2[j][1], 2)));
                }
            }
            System.out.println(String.format("%.3f", result));
        }
    }
}
