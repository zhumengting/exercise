package com.zmt.exercise.leetcode.page3;

import java.util.*;

public class SortString {

    public static void main(String[] args) {
        int[] array = {123, 232, 111, 111, 444, 2323};
        Set<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        Map<String, Integer> repeat = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (set.contains(String.valueOf(array[i]))) {
                if (repeat.containsKey(String.valueOf(array[i]))) {
                    repeat.put(String.valueOf(array[i]), repeat.get(String.valueOf(array[i])) + 1);
                }
                repeat.put(String.valueOf(array[i]), 2);
            } else {
                set.add(String.valueOf(array[i]));
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            String s = (String) iterator.next();
            if (repeat.containsKey(s)) {
                int i = repeat.get(s);
                while (i > 0) {
                    stringBuilder.append(s);
                    i--;
                }
            } else {
                stringBuilder.append(s);
            }
        }

        System.out.println(stringBuilder.toString());
    }

}
