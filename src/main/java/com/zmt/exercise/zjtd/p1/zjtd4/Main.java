package com.zmt.exercise.zjtd.p1.zjtd4;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int couple = scanner.nextInt();
        int[][] result = new int[couple][];
        for (int i = 0; i < couple; i++) {
            int length = scanner.nextInt();
            int[] value = new int[length];
            for (int j = 0; j < length; j++) {
                value[j] = scanner.nextInt();
            }
            result[i] = find(length, value);
        }
        for (int i = 0; i < couple; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.printf(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] find(int n, int[] a) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] right_num = new int[n];
        int[] total_num = new int[n];
        for (int i = 1; i < n; i++) {
            if (a[i] <= a[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.empty() && a[stack.peek()] < a[i]) {
                    int pos = stack.pop();
                    right_num[pos] = i - pos - 1;
                }
                stack.push(i);
            }
        }
        while (!stack.empty()) {
            int pos = stack.pop();
            right_num[pos] = n - pos - 1;
        }
        stack.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] <= a[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.empty() && a[stack.peek()] < a[i]) {
                    int pos = stack.pop();
                    total_num[pos] = pos - i + right_num[pos] - 1;
                }
                stack.push(i);
            }
        }
        while (!stack.empty()) {
            int pos = stack.pop();
            total_num[pos] = pos + right_num[pos];
        }
        return total_num;
    }
}
