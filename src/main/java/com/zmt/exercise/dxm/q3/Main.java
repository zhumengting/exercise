package com.zmt.exercise.dxm.q3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int result = 0;
        for (int k = 0; k < n - a + 1; k++) {
            for (int q = 0; q < m - b + 1; q++) {
                int temp = 0;
                for (int i = k + 1; i < k + 1 + a && i <= n; i++) {
                    for (int j = q + 1; j < q + 1 + b && j <= m; j++) {
                        temp = Math.max(temp, i * j % 10);
                    }
                }
                result += temp;
            }
        }

        System.out.println(result);

    }
}
