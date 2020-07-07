package com.zmt.exercise.pdd.pdd1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long result = 0;
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] array = new int[number];

        for (int i = 0; i < number; i++) {
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array);

        for (int i = number - 1; i >= 0; i--) {
            if ((number - 1 - i) % 3 != 2) {
                result += array[i];
            }
        }
        System.out.println(result);
    }
}
