package com.zmt.exercise.leetcode.page3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuyBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] kp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            kp[i][0] = scanner.nextInt();
            for (int j = 0; j < kp[i][0]; j++) {
                int number = scanner.nextInt();
                kp[i][number] = 1;
            }
        }
        List<Integer> select = new ArrayList<>();
        System.out.println(getBooks(kp, m, k, 1, 1, 0, select));
    }

    public static int getBooks(int[][] kp, int m, int k, int now, int min, int max, List<Integer> select) {

               /* int result1 = (int) (x * Math.pow(2, x - 1) % (Math.pow(10, 9) + 7));
        System.out.println(result1);
*/

        for (int i = min; i <= k; i++) {
            select.add(i);
            if (now == m) {
                max = Math.max(max, getSuitable(kp, k, select));
            } else {
                max = getBooks(kp, m, k, now + 1, i + 1, max, select);
            }
            select.remove(now - 1);

        }
        return max;

    }

    public static int getSuitable(int[][] kp, int k, List<Integer> select) {
        int max = 0;
        boolean find = true;
        for (int i = 0; i < kp.length; i++) {
            find = true;
            for (int j = 1; j <= k; j++) {
                if (!select.contains(j) && kp[i][j] == 1) {
                    find = false;
                    break;
                }
            }
            if (find) {
                max++;
            }
        }
        return max;

    }

}
