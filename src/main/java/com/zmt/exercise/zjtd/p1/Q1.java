package com.zmt.exercise.zjtd.p1;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();
        for (int i = 0; i < lines; i++) {
            String str = scanner.next();
            System.out.println(change(str));
        }
    }

    public static String change(String str) {
        if (str.length() == 0 || str.length() == 1 || str.length() == 2) {
            return str;
        }
        int[] sim = new int[str.length()];
        StringBuilder stringBuilder = new StringBuilder();
        int begin = 0;
        int end = begin + 2;
        while (end < str.length()) {
            if (str.charAt(begin) != str.charAt(begin + 1)) {
                stringBuilder.append(str.charAt(begin));
            } else {
                if (sim[begin] == 0 && str.charAt(begin) != str.charAt(end)) {
                    stringBuilder.append(str.charAt(begin));
                    sim[end] = 1;
                } else if (sim[begin] == 1 && str.charAt(begin) == str.charAt(end)) {
                    sim[begin + 1] = 1;
                }
            }

            begin++;
            end++;

        }
        if (!(sim[begin] == 1 && str.charAt(begin) == str.charAt(begin + 1))) {
            stringBuilder.append(str.charAt(begin));
        }
        stringBuilder.append(str.charAt(begin + 1));
        return stringBuilder.toString();
    }

}
