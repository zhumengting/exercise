package com.zmt.exercise.leetcode.leetcodegame;

public class Q4 {

    public int minJump(int[] jump) {
        int size = jump.length;
        int[] times = new int[size];
        for (int i = 0; i < size; i++) {
            if (i + jump[i] >= size) {
                times[i] = 1;
            } else {
                times[i] = Integer.MAX_VALUE;
            }
        }
        boolean changeVal = false;
        boolean find = false;
        int min = Integer.MAX_VALUE;
        while (times[0] == Integer.MAX_VALUE) {
            changeVal = false;
            find = false;
            min = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                if (times[i] != Integer.MAX_VALUE) {
                    min = Math.min(min, times[i]);
                    find = true;
                } else {
                    if (find) {
                        changeVal = true;
                        times[i] = min + 1;
                    } else if (times[i + jump[i]] != Integer.MAX_VALUE) {
                        changeVal = true;
                        times[i] = times[i + jump[i]] + 1;
                    }
                }
            }
            if (!changeVal) {
                return -1;
            }
        }
        return times[0];

    }
}
