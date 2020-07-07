package com.zmt.exercise.leetcode;

import java.util.Stack;

public class Q739 {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int position = stack.pop();
                result[position] = i - position;
            }
            stack.push(i);
        }
        return result;

    }
}
