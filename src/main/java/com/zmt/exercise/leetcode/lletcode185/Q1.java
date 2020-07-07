package com.zmt.exercise.leetcode.lletcode185;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q1 {
    public static void main(String[] args) {
        reformat("a0b1c2");
    }

    public static String reformat(String s) {
        LinkedList<Character> listDigital = new LinkedList<>();
        LinkedList<Character> listChar = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (isDigital(s.charAt(i))) {
                listDigital.add(s.charAt(i));

            } else {
                listChar.add(s.charAt(i));
            }
        }

        int digital = listDigital.size();
        int character = listChar.size();
        StringBuilder stringBuilder = new StringBuilder();
        if (digital == character) {
            stringBuilder.append(generator(listDigital, listChar));
        } else if (digital + 1 == character) {
            stringBuilder.append(listChar.poll());
            stringBuilder.append(generator(listDigital, listChar));
        } else if (digital == character + 1) {
            stringBuilder.append(listDigital.poll());
            stringBuilder.append(generator(listChar, listDigital));
        }
        return stringBuilder.toString();
    }

    public static boolean isDigital(char a) {
        if (a >= 48 && a < 58) {
            return true;
        }
        return false;
    }

    public static StringBuilder generator(LinkedList<Character> a, LinkedList<Character> b) {
        StringBuilder stringBuilder = new StringBuilder();
        while (!a.isEmpty()) {
            stringBuilder.append(a.poll());
            stringBuilder.append(b.poll());
        }
        return stringBuilder;
    }
}
