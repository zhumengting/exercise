package com.zmt.exercise.leetcode.dp;

public class Q673 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3, 5, 4, 7, 2};
        findNumberOfLIS(nums);
    }

    public static int findNumberOfLIS(int[] nums) {
        int number = 0;
        int max = 0;
        int[] array = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            array[i] = 1;

            if (array[i] > max) {
                max = array[i];
                number = 1;
            } else if (array[i] == max) {
                number++;
            }

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && array[i] <= array[j] + 1) {
                    array[i] = array[j] + 1;
                    if (array[i] > max) {
                        max = array[i];
                        number = 1;

                    } else if (array[i] == max) {
                        number += 1;
                    }
                }
            }
        }
        return number;
    }
}
