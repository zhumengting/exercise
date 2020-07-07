package com.zmt.exercise.leetcode.page6;

import java.util.*;

public class Q207 {
    public static void main(String[] args) {
        int[][] val = {{1, 0}, {0, 1}};
        System.out.println(canFinish(2, val));

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean result = true;
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            LinkedList<Integer> newList = null;
            if ((newList = map.get(prerequisites[i][0])) == null) {
                newList = new LinkedList<>();
            }
            newList.add(prerequisites[i][1]);
            map.put(prerequisites[i][0], newList);
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            result &= check(key, map);
        }

        return result;
    }

    public static boolean check(int key, Map<Integer, LinkedList<Integer>> map) {
        LinkedList<Integer> val = map.get(key);
        boolean result = true;
        Set<Integer> check = new HashSet<>();
        check.add(key);
        while (!val.isEmpty()) {
            int temp = val.poll();
            if (temp == key) {
                return false;
            }
            if (!check.contains(temp)) {
                check.add(temp);
                if (map.get(temp) != null) {
                    val.addAll(map.get(temp));
                }
            }
        }

        return result;
    }
}
