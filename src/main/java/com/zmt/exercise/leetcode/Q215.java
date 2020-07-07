package com.zmt.exercise.leetcode;

import java.util.PriorityQueue;

public class Q215 {
    public int findKthLargest(int[] nums, int k) {
        MyPriority myPriority = new MyPriority(k);
        for(int i = 0; i < nums.length; i++){
            myPriority.add(nums[i]);
        }
        return myPriority.get();
    }

    class MyPriority {
        private PriorityQueue<Integer> priorityQueue;
        private int size;

        public MyPriority(int size) {
            priorityQueue = new PriorityQueue<>();
            this.size = size;
        }

        public void add(int value) {
            if(priorityQueue.size() < size) priorityQueue.add(value);
            else if(priorityQueue.peek() < value){
                priorityQueue.poll();
                priorityQueue.add(value);
            }
        }
        public int get(){
            return priorityQueue.peek();
        }
    }
}
