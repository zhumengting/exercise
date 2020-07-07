package com.zmt.exercise.leetcode.page3;

import java.util.Scanner;

public class DivideCargo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] number = new int[6];
        int max = 0;
        for (int i = 0; i < 6; i++) {
            number[i] = scanner.nextInt();
            max += (i + 1) * number[i];
        }
        if (max % 2 == 1 || !getResult(number, 0, 6, 0, max / 2)) {
            System.out.println("Can't be divided.");
        } else {
            System.out.println("Can be divided.");
        }
    }

    public static boolean getResult(int[] number, int now, int n, int total, int target) {
        boolean result = false;
        int size = number[now];
        for (int i = 0; i <= size; i++) {
            total += i * (now + 1);
            if (now < n - 1) {
                result = result || getResult(number, now + 1, n, total, target);
                if (result) {
                    return result;
                }
            }
            if (total > target) {
                break;
            }
            if (total == target) {
                return true;
            }
            total -= i * (now + 1);

        }
        return result;

    }
}
