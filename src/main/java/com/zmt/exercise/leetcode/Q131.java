package com.zmt.exercise.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q131 {

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s.length() == 0) return result;
        if (s.length() == 1) {
            List<String> list = new ArrayList<>();
            result.add(list);
            return result;
        }
        boolean[][] matrix = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            matrix[i][i] = true;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) matrix[i][i - 1] = true;
        }
        Map<Integer, List<List<String>>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            List<List<String>> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j < i - 1 && s.charAt(i) == s.charAt(j) && matrix[i - 1][j + 1]) {
                    matrix[i][j] = true;
                }
                if (matrix[i][j]) {
                    if (j == 0) {
                        List<String> l = new ArrayList<>();
                        l.add(s.substring(j, i + 1));
                        temp.add(l);
                    } else {
                        List<List<String>> before = map.get(j - 1);
                        for (int k = 0; k < before.size(); k++) {
                            List<String> l = new ArrayList<>();
                            l.addAll(before.get(k));
                            l.add(s.substring(j, i + 1));
                            temp.add(l);
                        }
                    }

                }

            }
            map.put(i, temp);
        }
        return map.get(s.length() - 1);
    }

    public static void main(String[] args) {
        partition("aab");
    }
}
