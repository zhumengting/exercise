package com.zmt.exercise.leetcode;

import java.util.*;

public class Q1713 {
    public int respace(String[] dictionary, String sentence) {
        Map<Character, List<String>> map = new HashMap<>();
        for (int i = 0; i < dictionary.length; i++) {
            List<String> list;
            if ((list = map.get(dictionary[i].charAt(dictionary[i].length() - 1))) == null) {
                list = new ArrayList<>();
            }
            list.add(dictionary[i]);
            map.put(dictionary[i].charAt(dictionary[i].length() - 1), list);
        }

        int[] result = new int[sentence.length() + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        for (int i = 1; i <= sentence.length(); i++) {
            List<String> list;
            result[i ] = result[i-1] + 1;
            if ((list = map.get(sentence.charAt(i-1))) == null) {
                continue;
            }
            for (int j = 0; j < list.size(); j++) {
                String temp = list.get(j);
                if (temp.length() <= i && temp.equals(sentence.substring(i - temp.length(), i))) {
                    result[i] = Math.min(result[i], result[i - temp.length()]);
                }
            }
        }
        return result[sentence.length()];
    }
}
