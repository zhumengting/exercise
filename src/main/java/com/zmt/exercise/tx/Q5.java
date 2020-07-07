package com.zmt.exercise.tx;

import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        for (int i = 0; i < size; i++) {
            long x = scanner.nextLong();
            int k = scanner.nextInt();
            long later = (long) Math.pow(2, k);
            if (x < later) {
                System.out.println(-1);
                continue;
            }
            while (x >= later) {
                x = x / 2;
            }
            System.out.println(x);
        }
    }
}
