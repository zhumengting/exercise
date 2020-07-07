package com.zmt.exercise.pdd.pdd4;

import java.util.Scanner;

public class Main {
    static int maxVal = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        solution(array, k, 0);
        System.out.println(maxVal);
    }

    public static void solution(int[] array, int remain, int begin) {
        if (remain == 0) {
            maxVal = Math.max(maxVal, cal(array));
            return;
        }
        for (int i = begin; i < array.length; i++) {
            int temp = array[i];
            array[i] = -1;
            solution(array, remain - 1, i + 1);
            array[i] = temp;
        }
    }

    public static int cal(int[] array) {
        int count = 1;
        int max = 0;
        int before = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || (array[i] != before && array[i] != -1)) {
                max = Math.max(max, count);
                count = 1;
            } else if (array[i] == before) {
                count++;
            }
            if (array[i] != -1) {
                before = array[i];
            }

        }
        max = Math.max(max, count);
        return max;
    }
}
