package com.zmt.exercise.leetcode.page3;

import java.util.Scanner;

public class SolveFunction {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] kp = new int[n][2];
        for (int i = 0; i < n; i++) {
            kp[i][0] = scanner.nextInt();
            kp[i][1] = scanner.nextInt();
        }

        System.out.println(getResult(kp, n, M, 0, 0));
    }

    private static int getResult(int[][] kp, int n, int M, int now, int nowVal) {
        int result = 0;
        int nowValue = 0;
        for (int i = 1; i <= M; i++) {
            nowValue = (int) (kp[now][0] * Math.pow(i, kp[now][1]));
            nowVal += nowValue;
            if (now < n - 1) {
                result += getResult(kp, n, M, ++now, nowVal);
                now--;
            } else if (nowVal == 0) {
                result++;
            }
            if (nowVal > 0 && isMin(kp, now, n)) {
                break;
            }
            nowVal -= nowValue;
        }
        return result;

    }

    private static boolean isMin(int[][] kp, int begin, int end) {
        boolean isMin = true;
        for (int i = begin; i < end; i++) {
            if (kp[i][0] < 0) {
                isMin = false;
                break;
            }
        }
        return isMin;
    }
}
