package com.zmt.exercise.leetcode.slidewindows;

import java.util.HashMap;
import java.util.Map;

public class Q76 {
    public static void main(String[] args) {
        minWindow("ADOBECODEBANC", "ABC");
    }

    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        int min_begin = -1;
        int min_end = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            mapPut(t.charAt(i), map);
        }
        Map<Character, Integer> countMap = new HashMap<>(map);
        Map<Character, Integer> existMap = new HashMap<>(map);
        int begin = 0, end = 0;
        while (end < s.length()) {
            while (existMap.size() > 0 && end < s.length()) {
                mapRemove(s.charAt(end), countMap, existMap);
                end++;
            }
            if (existMap.size() > 0) break;

            if (min_begin == -1 || end - 1 - begin < min_end - min_begin) {
                min_begin = begin;
                min_end = end - 1;
            }

            for (int i = begin; i < end; i++) {
                if (mapAdd(s.charAt(i), countMap, existMap)) {
                    if (end - 1 - i < min_end - min_begin) {
                        min_begin = i;
                        min_end = end - 1;
                    }
                    begin = i + 1;
                    break;
                }
            }

        }
        if (min_begin == -1) return "";
        StringBuilder str = new StringBuilder();
        for (int i = min_begin; i <= min_end; i++) {
            str.append(s.charAt(i));
        }
        return str.toString();

    }

    public static void mapPut(Character val, Map<Character, Integer> map) {
        if (map.get(val) != null) map.put(val, map.get(val) + 1);
        else map.put(val, 1);
    }

    public static boolean mapRemove(Character val, Map<Character, Integer> countMap, Map<Character, Integer> existMap) {
        if (countMap.get(val) == null) return false;
        else {
            countMap.put(val, countMap.get(val) - 1);
            if (countMap.get(val) <= 0 && existMap.get(val) != null) {
                existMap.remove(val);
            }
        }
        return true;
    }

    public static boolean mapAdd(Character val, Map<Character, Integer> countMap, Map<Character, Integer> existMap) {
        if (countMap.get(val) == null) return false;
        else {
            countMap.put(val, countMap.get(val) + 1);
            if (countMap.get(val) > 0) {
                existMap.put(val, countMap.get(val));
                return true;
            }
        }
        return false;
    }
}
