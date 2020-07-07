package com.zmt.exercise.leetcode.leetcodegame;

import java.util.Arrays;

public class Q3_2 {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[] result = new int[requirements.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }
        int check = 0;
        judge(result, requirements, new int[3], check);
        for (int i = 0; i < increase.length; i++) {
            judge(result, requirements, increase[i], ++check);
        }

        return result;
    }

    public void judge(int[] result, int[][] requ, int[] decrese, int check) {
        for (int i = 0; i < result.length; i++) {
            if (result[i] > -1) {
                continue;
            }
            requ[i][0] -= decrese[0];
            requ[i][1] -= decrese[1];
            requ[i][2] -= decrese[2];

            if (requ[i][0] <= 0 && requ[i][1] <= 0 && requ[i][2] <= 0) {
                result[i] = check;
            }
        }
    }
}
