package com.zmt.exercise.leetcode.slidewindows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> results = new ArrayList<>();
        if (words.length == 0 || words[0].length() == 0) return results;
        int size = words[0].length();
        int begin = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            mapPut(words[i], map);
        }
        Map<String, Integer> mapTemp = new HashMap<>(map);
        int end = begin + size;
        while (end <= s.length() && begin + size * words.length <= s.length()) {
            if (map.get(s.substring(end - size, end)) == null) {
                begin = begin + 1;
                end = begin + size;
                mapTemp = new HashMap<>(map);
                continue;
            }
            if (mapRemove(s.substring(end - size, end), mapTemp)) {
                if (mapTemp.size() == 0) {
                    results.add(begin);
                    begin = begin + 1;
                    end = begin + size;
                    mapTemp = new HashMap<>(map);
                } else {
                    end = end + size;
                }

            } else {
                mapPut(s.substring(begin, begin + size), mapTemp);
                begin = begin + 1;
                end = begin + size;
            }
        }
        return results;

    }

    public void mapPut(String val, Map<String, Integer> map) {
        if (map.get(val) != null) map.put(val, map.get(val) + 1);
        else map.put(val, 1);
    }

    public boolean mapRemove(String val, Map<String, Integer> map) {
        if (map.get(val) == null) return false;
        if (map.get(val) == 1) map.remove(val);
        else map.put(val, map.get(val) - 1);
        return true;
    }
}
