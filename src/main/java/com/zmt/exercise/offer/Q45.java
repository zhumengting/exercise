package com.zmt.exercise.offer;

import java.util.*;

public class Q45 {
    public static String minNumber(int[] nums) {
        TreeMap<String, Integer> treeSet = new TreeMap<>((o1, o2) -> {
            int compare = (o1 + o2).compareTo(o2 + o1);
            if (compare == 0) return -1;
            return compare;

        });
        for (int i = 0; i < nums.length; i++) {
            String val = String.valueOf(nums[i]);
            if (treeSet.containsKey(val)) {
                treeSet.put(val, treeSet.get(val) + 1);
            } else {
                treeSet.put(val, 1);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Map.Entry<String, Integer>> iterator = treeSet.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String key = entry.getKey();
            Integer val = entry.getValue();
            while (val > 0) {
                stringBuilder.append(key);
                val--;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1011, 10, 1000};
        minNumber(nums);
    }
}
