package com.zmt.exercise.leetcode.leetcod194;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        String[] val = new String[length];
        for(int i = 0; i < length; i++){
            val[i] = scanner.next();
        }
        getFolderNames(val);
    }
    public static String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] result = new String[names.length];

        for (int i = 0; i < names.length; i++) {
            Integer val;
            String temp;
            if ((val = map.get(names[i])) != null) {
                temp = names[i] + "(" + val + ")";
                while (map.get(temp) != null) {
                    val++;
                    temp = names[i] + "(" + val + ")";
                }
                result[i] = temp;
                map.put(temp,1);
                map.put(names[i], val + 1);
                continue;
            }
            map.putIfAbsent(names[i], 1);
            result[i] = names[i];

        }
        return result;
    }
}
