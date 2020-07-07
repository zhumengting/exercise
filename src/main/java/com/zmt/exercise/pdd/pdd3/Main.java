package com.zmt.exercise.pdd.pdd3;

import java.util.*;

public class Main {
    private static class Node implements Comparable<Node> {
        private int position;
        private int val;

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node(int position, int val) {
            this.position = position;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            if (this.getVal() == o.getVal()) {
                return o.getPosition() - this.getPosition();
            }
            return this.getVal() - o.getVal();
        }
    }

    public static void main(String[] args) {
        int result = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String str = scanner.next();
        char[] chars = str.toCharArray();
        int[] value = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            value[i] = chars[i] - 48;
        }
        int min = Integer.MAX_VALUE;
        int position = 0;

        for (int i = 0; i < 10; i++) {
            Set<Node> set = new TreeSet<>();
            for (int j = 0; j < value.length; j++) {
                set.add(new Node(j, Math.abs(value[j] - i)));
            }
            Iterator<Node> iterator = set.iterator();
            int count = 0;
            for (int j = 0; j < k; j++) {
                Node node = iterator.next();
                count += node.getVal();
            }
            if (count < min) {
                min = count;
                position = i;
            }
        }

        Set<Node> set2 = new TreeSet<>();
        for (int j = 0; j < value.length; j++) {
            set2.add(new Node(j, Math.abs(value[j] - position)));
        }
        Iterator<Node> iterator = set2.iterator();
        int count = 0;
        for (int i = 0; i < k; i++) {
            Node node = iterator.next();
            value[node.getPosition()] = position;
            count += node.getVal();
        }
        StringBuilder stringBuilder = new StringBuilder();

        for (int j = 0; j < value.length; j++) {
            stringBuilder.append(value[j]);
        }
        System.out.println(count);
        System.out.println(stringBuilder.toString());

    }
}
