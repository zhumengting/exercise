package com.zmt.exercise.leetcode.leetcodegame;

import java.util.Arrays;

public class Q3 {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[] now = new int[3];
        int[] start = new int[requirements.length];
        int[] result = new int[requirements.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }
        judge(start, result, now, requirements);
        for (int i = 0; i < increase.length; i++) {
            now[0] += increase[i][0];
            now[1] += increase[i][1];
            now[2] += increase[i][2];
            judge(start, result, now, requirements);
        }
        for (int i = 0; i < start.length; i++) {
            if (start[i] == 0) {
                result[i] = -1;
            }
        }
        return result;
    }

    public void judge(int[] status, int[] result, int[] now, int[][] requ) {
        for (int i = 0; i < status.length; i++) {
            if (status[i] == 1) {
                continue;
            }
            result[i] += 1;
            if (now[0] >= requ[i][0] && now[1] >= requ[i][1] && now[2] >= requ[i][2]) {
                status[i] = 1;
            }
        }
    }
}
