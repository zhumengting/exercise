package com.zmt.exercise.leetcode.leetcode196;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Q4 {
    static class Node {
        int value;
        int position;

        public Node(int value, int position) {
            this.value = value;
            this.position = position;
        }

    }

    public static String minInteger(String num, int k) {
        char[] value = num.toCharArray();

        TreeSet<Node> treeSet = new TreeSet<>((o1, o2) -> {
            if (o1.value == o2.value)
                return o1.position - o2.position;
            else return o1.value - o2.value;
        });

        int[] result = new int[value.length];

        for (int i = 0; i < value.length; i++) {
            Node node = new Node(value[i] - '0', i);
            treeSet.add(node);
        }

        int targetPosition = 0;
        StringBuilder stringBuilder = new StringBuilder();
        Set<Integer> positions = new HashSet<>();

        while (!treeSet.isEmpty() && k > 0) {
            Set<Node> nodes = new HashSet<>();
            Node temp = treeSet.pollFirst();
            while (temp != null && temp.position + result[temp.position] - targetPosition > k) {
                nodes.add(new Node(temp.value, temp.position));
                temp = treeSet.pollFirst();
            }
            treeSet.addAll(nodes);
            if (temp == null) break;
            k -= temp.position + result[temp.position] - targetPosition;
            addPosition(result, temp.position);
            stringBuilder.append(temp.value);
            positions.add(temp.position);
            targetPosition++;
        }
        for (int i = 0; i < value.length; i++) {
            if (positions.contains(i)) continue;
            stringBuilder.append(value[i]);
        }

        return stringBuilder.toString();
    }

    public static void addPosition(int[] value, int pos) {
        for (int i = 0; i < pos; i++) {
            value[i] += 1;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println(minInteger("294984148179", 11));
    }
}
