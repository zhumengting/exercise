package com.zmt.exercise.leetcode.interval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q621 {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        Object[] array = queue.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println((Integer) array[i]);
        }
    }

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        int[] array = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            array[tasks[i] - 'A']++;
        }
        Arrays.sort(array);
        boolean flag = false;
        int size = n + 1;
        int result = 0;
        while (true) {
            size = n + 1;
            for (int i = array.length - 1; i >= 0; i--) {
                if (size > 0) {
                    array[i]--;
                    size--;
                    if (flag && array[i] < 0) break;
                    result++;
                } else {
                    if (i < array.length - 1 && array[i] > array[i + 1]) Arrays.sort(array);
                    break;
                }
            }
            if (array[array.length - 1] == 0) {
                break;
            }
            result += size;
        }
        return result;
    }
}
