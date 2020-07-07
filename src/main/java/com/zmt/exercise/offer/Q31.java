package com.zmt.exercise.offer;

import java.util.Stack;

public class Q31 {
    public static void main(String[] args) {
        int[] push = {1, 2, 0};
        int[] pop = {2, 1, 0};
        validateStackSequences(push, pop);
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int firstIndex = 0;
        int secondIndex = 0;
        if (pushed.length != popped.length) {
            return false;
        }
        if (pushed.length == 0) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(pushed[firstIndex]);
        firstIndex++;
        while (firstIndex < pushed.length || secondIndex < popped.length) {
            if (!stack.isEmpty() && stack.peek() == popped[secondIndex]) {
                secondIndex++;
                stack.pop();
            } else if (firstIndex < pushed.length) {
                stack.push(pushed[firstIndex]);
                firstIndex++;
            }
            if (firstIndex == pushed.length && !stack.isEmpty() && stack.peek() != popped[secondIndex]) {
                return false;
            }

        }
        return true;
    }
}
