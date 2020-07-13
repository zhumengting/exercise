package com.zmt.exercise.zjtd.p1;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q440 {
    public int findKthNumber(int n, int k) {
        MyQueue myQueue = new MyQueue(k);
        for(int i = 1; i <= n; i++){
            myQueue.add(String.valueOf(i));
        }
        return Integer.parseInt(myQueue.get());
    }

    class MyQueue {
        PriorityQueue<String> queue;
        int size;

        MyQueue(int size) {
            queue = new PriorityQueue<>(Comparator.reverseOrder());
            this.size = size;
        }

        void add(String val) {
            if (queue.size() < size) {
                queue.add(val);
            } else if (queue.peek().compareTo(val) > 0) {
                queue.poll();
                queue.add(val);

            }
        }

        String get() {
            return queue.peek();
        }
    }
}
