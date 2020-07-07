package com.zmt.exercise.leetcode.slidewindows;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxVal = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int begin = 0;
        int end = k - 1;
        offer(begin, end, deque, nums);
        maxVal[0] = deque.peekLast();
        for (int i = 0; i < maxVal.length - 1; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == nums[i])
                deque.pollFirst();
            if (deque.isEmpty()) {
                offer(i + 1, i + k, deque, nums);
            } else if (deque.peekLast() <= nums[i + k]) {
                deque.offerLast(nums[i + k]);
            }

            maxVal[i + 1] = deque.peekLast();
        }

        return maxVal;

    }

    public void offer(int begin, int end, Deque<Integer> deque, int[] nums) {
        for (int i = begin; i <= end; i++) {
            if (deque.isEmpty() || deque.peekLast() <= nums[i]) {
                deque.offerLast(nums[i]);
            }
        }
    }
}
