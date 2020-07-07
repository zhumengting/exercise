package com.zmt.exercise.pdd.pdd2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long result = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] tree = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i] = scanner.nextInt();
        }
        int[] store = new int[m];
        for (int i = 0; i < n; i++) {
            tree[i] = tree[i] % m;
        }
        for (int num : tree) {
            int[] temp = new int[m];
            for (int i = 0; i < m; i++) {
                temp[(i + num) % m] = store[i];
            }
            temp[num % m]++;
            store = temp;
            result += store[0];
        }

        System.out.println(result);

    }

}
