package com.zmt.exercise.leetcode.leetcodegame;

import java.util.*;

public class Main {
    private class Node {
        int val;
        int position;

        public Node(int val, int position) {
            this.val = val;
            this.position = position;
        }
    }

    public int numWays(int n, int[][] relation, int k) {
        if (relation.length == 0 || relation[0].length == 0) {
            return 0;
        }
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < relation.length; i++) {
            LinkedList<Integer> linkedList = null;
            if ((linkedList = map.get(relation[i][0])) == null) {
                linkedList = new LinkedList<>();
            }
            linkedList.add(relation[i][1]);
            map.put(relation[i][0], linkedList);
        }
        Stack<Node> stack = new Stack<>();
        stack.addAll(getNode(map, 0, 1));
        Node node = null;
        int times = 0;
        while (!stack.isEmpty()) {
            node = stack.pop();
            if (node.position == k) {
                if (node.val == n - 1) {
                    times += +1;
                }
                continue;
            }
            stack.addAll(getNode(map, node.val, node.position + 1));
        }
        return times;
    }

    public LinkedList<Node> getNode(Map<Integer, LinkedList<Integer>> map, int val, int position) {

        if (map.get(val) == null) {
            return new LinkedList<>();
        }
        LinkedList<Integer> integers = map.get(val);
        if (integers == null) {
            return new LinkedList<>();
        }
        LinkedList<Node> nodes = new LinkedList<>();
        for (Integer i : integers) {
            nodes.push(new Node(i, position));
        }
        return nodes;

    }
}
