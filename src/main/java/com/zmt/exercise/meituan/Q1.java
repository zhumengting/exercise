package com.zmt.exercise.meituan;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] max = new int[m];
        Map<Integer, Set<Integer>> map = new HashMap<>();

        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp = scanner.nextInt();
                if (max[j] > temp) continue;
                if (max[j] < temp) {
                    max[j] = temp;
                    map.put(j, new HashSet<Integer>());
                }
                map.get(j).add(i);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            set.addAll(map.get(i));
        }
        System.out.println(set.size());
    }
}
