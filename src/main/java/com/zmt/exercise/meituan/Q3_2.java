package com.zmt.exercise.meituan;

import java.util.Scanner;

public class Q3_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean[] binansuo = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            int op = scanner.nextInt();
            int pos = scanner.nextInt();
            if (op == 1) binansuo[pos] = true;
            else {
                if (pos >= binansuo.length) {
                    System.out.println(-1);
                    continue;
                }
                if (!binansuo[pos]) {
                    System.out.println(pos);
                    continue;
                }
                while (pos < binansuo.length && binansuo[pos]) {
                    pos++;
                }
                if (pos >= binansuo.length) System.out.println(-1);
                else System.out.println(pos);
            }
        }
    }
}
