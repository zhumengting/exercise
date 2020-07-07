package com.zmt.exercise.offer;

import java.util.Stack;

public class Q01 {
    class CQueue {
        private Stack<Integer> s1;
        private Stack<Integer> s2;

        public CQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void appendTail(int value) {
            s1.push(value);
        }

        public int deleteHead() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        public boolean binarySearch(int[][] matrix, int target, int beginrow, int begincolumn, int endrow, int endcolumn) {
            if (matrix[beginrow][begincolumn] == target || matrix[endrow][endcolumn] == target) {
                return true;
            }
            if (matrix[beginrow][begincolumn] > target || matrix[endrow][endcolumn] < target) {
                return false;
            }
            if (endrow - beginrow <= 1 && endcolumn - begincolumn <= 1) {
                if (matrix[beginrow][endcolumn] == target || matrix[endrow][begincolumn] == target) {
                    return true;
                }
                return false;
            }
            int midrow = (beginrow + endrow) / 2;
            int midcolumn = (begincolumn + endcolumn) / 2;
            if (matrix[midrow][midcolumn] == target) {
                return true;
            } else if (matrix[midrow][midcolumn] < target) {
                return binarySearch(matrix, target, midrow, midcolumn, endrow, endcolumn);
            }
            return binarySearch(matrix, target, beginrow, begincolumn, midrow, midcolumn);

        }
    }
}
