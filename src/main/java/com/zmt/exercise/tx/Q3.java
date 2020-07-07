package com.zmt.exercise.tx;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] a = new int[size];
        int[] b = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < size; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(-1);

    }
}
