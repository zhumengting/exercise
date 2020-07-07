package com.zmt.exercise.leetcode.page3;

import java.util.*;

public class SortArray {

    public static void main(String[] args) {

        Set<List<Integer>> listList = new TreeSet<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int result = o1.get(0).compareTo(o2.get(0));
                result = result == 0 ? -1 : result;
                return result;
            }
        });
        int[][] values = {{1, 2, 3}, {5, 8, 10}, {4, 5, 6}, {4, 6, 7}, {5, 8, 11}, {11, 21, 31}};
        for (int i = 0; i < values.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < values[0].length; j++) {
                list.add(values[i][j]);
            }

            listList.add(list);
        }
        System.out.println("success");
    }
}
