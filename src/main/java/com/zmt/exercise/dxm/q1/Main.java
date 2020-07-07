package com.zmt.exercise.dxm.q1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[][] matrix = new int[n - a + 1][m - b + 1];
        int result = 0;
        for (int k = 0; k < n - a + 1; k++) {
            for (int q = 0; q < m - b + 1; q++) {
                for (int i = k + 1; i < k + 1 + a && i <= n; i++) {
                    for (int j = q + 1; j < q + 1 + b && j <= m; j++) {
                        matrix[k][q] = Math.max(matrix[k][q], i * j % 10);
                    }
                }
            }
        }

        for (int i = 0; i < n - a + 1; i++) {
            for (int j = 0; j < m - b + 1; j++) {
                result += matrix[i][j];
            }
        }
        System.out.println(result);

    }
}
