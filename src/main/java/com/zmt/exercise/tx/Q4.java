package com.zmt.exercise.tx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Node {
    String command;
    int val;

    public Node(String command) {
        this.command = command;
    }

    public Node(String command, int val) {
        this.command = command;
        this.val = val;
    }
}

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        MyQueue myQueue = new MyQueue();
        List<Node> commands = new ArrayList<>(size);
        for (int j = 0; j < size; j++) {
            Node node = new Node(scanner.next());
            if ("add".equals(node.command)) {
                node.val = scanner.nextInt();
            }
            commands.add(node);
        }
        Node temp = null;
        for (int j = 0; j < size; j++) {
            temp = commands.get(j);
            if ("add".equals(temp.command)) myQueue.add(temp.val);
            else if ("peek".equals(temp.command)) System.out.println(myQueue.peek() == null ? -1 : myQueue.peek());
            else if ("poll".equals(temp.command)) myQueue.poll();
        }
    }

    static class MyQueue {
        Stack<Integer> s1 = null;
        Stack<Integer> s2 = null;

        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();

        }

        public boolean add(Integer val) {
            return s1.add(val);
        }

        public Integer poll() {
            if (s2.isEmpty() && s1.isEmpty()) return null;
            if (s2.isEmpty()) {
                while (!s1.empty()) {
                    s2.add(s1.pop());
                }
            }
            return s2.pop();
        }

        public Integer peek() {
            if (s2.isEmpty() && s1.isEmpty()) return null;
            if (s2.isEmpty()) {
                while (!s1.empty()) {
                    s2.add(s1.pop());
                }
            }
            return s2.peek();
        }
    }
}
