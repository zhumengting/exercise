package com.zmt.exercise.leetcode;

public class Q837 {
    static class Node {
        int match;
        int total;
    }

    public static void main(String[] args) {
        new21Game(6, 2, 10);

    }

    public static double new21Game(int N, int K, int W) {
        Node node = new Node();
        calculate(node, N, K, W, 0);
        System.out.println("match: " + node.match + " total:" + node.total);
        return 1.0 * node.match / node.total;
    }

    public static void calculate(Node node, int N, int K, int W, int now) {

        if (K <= 0) {
            if (now <= N) {
                node.match += 1;
            }
            node.total += 1;
            return;
        }
        for (int i = 1; i <= W; i++) {
            calculate(node, N, K - i, W, now + i);
        }
    }
}
