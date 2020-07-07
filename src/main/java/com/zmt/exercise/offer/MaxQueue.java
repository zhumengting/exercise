package com.zmt.exercise.offer;

import java.util.LinkedList;

class MaxQueue {

    private LinkedList<Integer> linkedList;
    private LinkedList<Integer> maxList;

    public MaxQueue() {
        linkedList = new LinkedList<>();
        maxList = new LinkedList<>();
    }

    public int max_value() {
        if (maxList.isEmpty()) return -1;
        return maxList.peekLast();
    }

    public void push_back(int value) {
        linkedList.addLast(value);
        if (maxList.isEmpty()) allAll();
        else if (maxList.peekLast() <= value) maxList.addLast(value);
    }

    public int pop_front() {
        if (linkedList.isEmpty()) return -1;

        if (maxList.peekFirst().equals(linkedList.peekFirst())) maxList.pollFirst();
        return linkedList.pollFirst();

    }

    private void allAll() {
        for (Integer i : linkedList) {
            if (maxList.isEmpty() || maxList.peekLast() <= i) {
                maxList.addLast(i);
            }
        }
    }
}