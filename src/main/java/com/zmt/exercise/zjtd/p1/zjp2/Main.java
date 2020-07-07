package com.zmt.exercise.zjtd.p1.zjp2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long result = 0L;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] youhui = new int[n];
        int[] products = new int[m];
        for (int i = 0; i < n; i++) {
            youhui[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            products[i] = scanner.nextInt();
        }
        Arrays.sort(youhui);
        Arrays.sort(products);
        int position = n - 1;
        for (int i = m - 1; i >= 0; i--) {
            result += products[i];
            for (int j = position; j >= 0; j--) {
                if (youhui[j] <= products[i]) {
                    result -= youhui[j];
                    position = j;
                    break;
                }
            }
        }
        System.out.println(result);

    }
}
