package com.zmt.exercise.leetcode.dp;

import java.util.LinkedList;

public class Q312 {
    public static int maxCoins(int[] nums) {
        int result = 0;
        if (nums.length == 0) return result;

        boolean increaseFlag = false;
        Integer compare = nums[0];

        LinkedList<Integer> increase = new LinkedList<>();
        LinkedList<Integer> decrease = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            //默认以递增序列开始
            if ((i == 0 || increaseFlag) && nums[i] >= compare) {
                increase.add(nums[i]);
                if (!increaseFlag) increaseFlag = true;
            } else if (nums[i] > compare) {
                //如果遇到先递减后递增，需要弹出递减的值
                int poll = decrease.pollLast();
                while ((compare = decrease.peekLast()) != null && compare < nums[i]) {
                    result += nums[i] * compare * poll;
                    poll = decrease.pollLast();
                }
                if (compare == null && increase.size() == 0) {
                    result += nums[i] * poll;
                    compare = nums[i];
                    increase.add(nums[i]);
                    increaseFlag = true;
                } else if (compare == null) {
                    compare = increase.peekLast();
                    result += nums[i] * poll * compare;
                    if (compare <= nums[i]) {
                        increase.add(nums[i]);
                        increaseFlag = true;
                    } else {
                        decrease.add(nums[i]);
                    }
                } else {
                    result += nums[i] * compare * poll;
                    decrease.add(nums[i]);
                }

            } else {
                decrease.add(nums[i]);
                increaseFlag = false;
            }
            compare = nums[i];
        }
        int max = increase.pollLast();
        while (!increase.isEmpty()) {
            int now = increase.pollLast();
            int before = increase.isEmpty() ? 1 : increase.peekLast();
            result += max * now * before;
        }
        while (!decrease.isEmpty()) {
            int now = decrease.pollFirst();
            int before = decrease.isEmpty() ? 1 : decrease.peekFirst();
            result += max * now * before;
        }
        result += max;

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {9,7,6,4,9,8,9,3,18,23,455,92};
        maxCoins(nums);

    }

}

