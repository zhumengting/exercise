package com.zmt.exercise.dxm.q2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int[] distance = new int[n];
        int maxDistance = 0;
        for (int i = 0; i < n; i++) {
            distance[i] = scanner.nextInt();
            maxDistance = Math.max(maxDistance, distance[i]);
        }
        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++) {
            cost[i] = (n - distance[i - 1]) * c + a;
        }

        boolean change = true;
        while (change) {
            change = false;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j < i; j++) {

                    int val = b * (i - j) + cost[j] + a;
                    if (cost[i] > val) {
                        cost[i] = val;
                        change = true;
                    }

                }
                for (int j = i + 1; j <= n; j++) {
                    int val = c * (j - i) + cost[j] + a;
                    if (cost[i] > val) {
                        cost[i] = val;
                        change = true;
                    }

                }
            }

        }
        System.out.println(cost[1]);
    }
}
