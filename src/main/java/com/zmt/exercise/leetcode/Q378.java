package com.zmt.exercise.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q378 {
    public int kthSmallest(int[][] matrix, int k) {
        MyPriority myPriority = new MyPriority(k);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (!myPriority.add(matrix[i][j])) {
                    break;
                }
            }
        }
        return myPriority.get();
    }

    class MyPriority {
        private PriorityQueue<Integer> priorityQueue;
        private int size;

        public MyPriority(int size) {
            priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
            this.size = size;
        }

        public boolean add(int value) {
            boolean flag = true;
            if (priorityQueue.size() < size) {
                priorityQueue.add(value);
            } else if (priorityQueue.peek() > value) {
                priorityQueue.poll();
                priorityQueue.add(value);
            } else {
                flag = false;
            }
            return flag;
        }

        public int get() {
            if(priorityQueue.isEmpty()) return 0;
            return priorityQueue.peek();
        }
    }
}
