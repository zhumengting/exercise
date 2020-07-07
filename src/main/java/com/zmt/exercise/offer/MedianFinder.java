package com.zmt.exercise.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> priorityQueueSmall;
    PriorityQueue<Integer> priorityQueueBig;

    public MedianFinder() {
        //小顶堆 放置大的数
        priorityQueueSmall = new PriorityQueue<>();
        //大顶堆 放置小的数
        priorityQueueBig = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        if (priorityQueueBig.size() == 0) {
            priorityQueueBig.add(num);
            return;
        }
        int flag = priorityQueueBig.peek();

        if (flag <= num) {
            if (priorityQueueSmall.size() >= priorityQueueBig.size()) {
                if (num <= priorityQueueSmall.peek()) {
                    priorityQueueBig.add(num);
                } else {
                    priorityQueueBig.add(priorityQueueSmall.poll());
                    priorityQueueSmall.add(num);
                }

            } else {
                priorityQueueSmall.add(num);
            }
            return;
        }

        if (priorityQueueBig.size() > priorityQueueSmall.size()) {
            priorityQueueSmall.add(priorityQueueBig.poll());
        }
        priorityQueueBig.add(num);
    }

    public double findMedian() {

        if (priorityQueueBig.size() == 0) return 0.0;
        if (priorityQueueBig.size() > priorityQueueSmall.size())
            return priorityQueueBig.peek();
        return 1.0 * (priorityQueueBig.peek() + priorityQueueSmall.peek()) / 2;
    }
}
