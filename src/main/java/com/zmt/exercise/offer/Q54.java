package com.zmt.exercise.offer;

import java.util.PriorityQueue;

public class Q54 {
    class MyPriorityQueue {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int size;

        public MyPriorityQueue(int size) {
            this.size = size;
        }

        public void add(int value) {
            if (priorityQueue.size() < size) {
                priorityQueue.add(value);
            } else if (!priorityQueue.isEmpty() && priorityQueue.peek() < value) {
                priorityQueue.poll();
                priorityQueue.add(value);
            }
        }

        public Integer get() {
            if (priorityQueue.isEmpty() && priorityQueue.size() < size) return null;
            return priorityQueue.peek();
        }
    }

    public int kthLargest(TreeNode root, int k) {
        MyPriorityQueue myPriorityQueue = new MyPriorityQueue(k);
        addVal(root,myPriorityQueue);
        return myPriorityQueue.get();
    }

    public void addVal(TreeNode root, MyPriorityQueue myPriorityQueue) {
        if(root == null) return;
        myPriorityQueue.add(root.val);
        addVal(root.left,myPriorityQueue);
        addVal(root.right,myPriorityQueue);
    }
}
