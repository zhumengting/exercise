package com.zmt.exercise.meituan;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] array = new int[number];
        for (int i = 0; i < number; i++) {
            array[i] = scanner.nextInt();
        }
        int result = 0;
        for (int i = 0; i < number; i++) {
            for (int j = i + 1; j < number; j++) {
                result = Math.max(result, Integer.bitCount(array[i] ^ array[j]));
            }
        }
        System.out.println(result);
    }
}
