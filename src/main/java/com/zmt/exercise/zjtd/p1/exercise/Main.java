package com.zmt.exercise.zjtd.p1.exercise;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String val = in.next();
        System.out.println(find(val));
    }

    public static String find(String value) {
        if (value.length() == 0) return "";
        int begin = 0, end = 0, max = 0, max_begin = 0, max_end = 0;
        Set<Character> set = new HashSet<>();
        while (end < value.length()) {
            if (!set.contains(value.charAt(end))) {

                set.add(value.charAt(end));
                end++;
                continue;
            }

            if (end - begin + 1 > max) {
                max = end - begin;
                max_begin = begin;
                max_end = end - 1;
            }
            while (value.charAt(begin) != value.charAt(end)) {
                set.remove(value.charAt(begin));
                begin++;
            }
            begin++;
            end++;
        }
        StringBuilder str = new StringBuilder();
        for (int i = max_begin; i <= max_end; i++) {
            str.append(value.charAt(i));
        }
        return str.toString();

    }
}