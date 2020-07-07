package com.zmt.exercise.leetcode.interval;

import java.util.Iterator;
import java.util.TreeSet;

public class Q435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        TreeSet<Node> nodes = new TreeSet<>();
        for (int i = 0; i < intervals.length; i++) {
            nodes.add(new Node(intervals[i][0], intervals[i][1]));
        }
        Iterator<Node> iterator = nodes.iterator();
        if (!iterator.hasNext()) {
            return 0;
        }
        int result = 0;
        Node before = iterator.next();
        Node now = null;
        while (iterator.hasNext()) {
            now = iterator.next();
            if (now.begin < before.end) {
                result++;
                if(now.end <= before.end){
                    before = now;
                }

            } else {
                before = now;
            }
        }
        return result;
    }

    class Node implements Comparable<Node> {
        int begin;
        int end;

        public Node() {
        }

        public Node(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            if (begin < o.begin) {
                return -1;
            }
            if (begin > o.begin) {
                return 1;
            }
            if (end < o.end) {
                return -1;
            }
            return 1;
        }
    }

    public int findMinArrowShots(int[][] points) {
        TreeSet<Node> nodes = new TreeSet<>();
        for (int i = 0; i < points.length; i++) {
            nodes.add(new Node(points[i][0], points[i][1]));
        }
        Iterator<Node> iterator = nodes.iterator();
        if (!iterator.hasNext()) {
            return 0;
        }
        Node before = iterator.next();
        Node now = null;
        int result = 1;
        while (iterator.hasNext()) {
            now = iterator.next();
            if (now.begin <= before.end) {
                now.end = Math.min(now.end,before.end);
            } else {
                result++;
            }
            before = now;
        }
        return result;

    }
}

