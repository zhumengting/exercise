package com.zmt.exercise.zjtd.p1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int couple = scanner.nextInt();
        String[][] vals = new String[couple][2];
        for (int i = 0; i < couple; i++) {
            int length = scanner.nextInt();
            StringBuilder s1 = new StringBuilder();
            for (int j = 0; j < length; j++) {
                s1.append(scanner.nextInt());
            }
            StringBuilder s2 = new StringBuilder();
            for (int j = 0; j < length; j++) {
                s2.append(scanner.nextInt());
            }
            vals[i][0] = s1.toString();
            vals[i][1] = s2.toString();
        }
        for (int i = 0; i < couple; i++) {
            System.out.println(check(vals[i][0], vals[i][1]));
        }
    }

    public static String check(String val1, String val2) {
        char[] s1 = val1.toCharArray();
        char[] s2 = val2.toCharArray();
        int temp;
        int before = 0;
        boolean isEnd = false;
        boolean firstZero = false;
        for (int i = val1.length() - 1; i >= 0; i--) {
            temp = s2[i] - s1[i];
            if (temp < 0) {
                return "NO";
            }
            if (!firstZero && temp == 0) {
                continue;
            } else if (!firstZero && temp != 0) {
                firstZero = true;
                before = temp;
            } else if (!isEnd && temp != before) {
                if (temp == 0) {
                    isEnd = true;
                    before = 0;
                } else {
                    return "NO";
                }
            } else if (isEnd && temp != 0) {
                return "NO";
            }
        }

        return "YES";
    }
}
