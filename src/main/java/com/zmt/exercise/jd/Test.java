package com.zmt.exercise.jd;

import java.util.LinkedList;

public class Test {
    static class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node begin = new Node(1);
        begin.next = new Node(2);
        Node reverseNode = reverse(begin);
        while (reverseNode != null){
            System.out.println(reverseNode.val);
            reverseNode = reverseNode.next;
        }
    }

    public static Node reverse(Node node){
        LinkedList<Node> nodes = new LinkedList<>();
        while (node!= null){
            nodes.add(node);
            node = node.next;
        }
        Node begin = null;
        Node now = null;
        while (!nodes.isEmpty()){
            if(begin == null){
                begin = nodes.pollLast();
                now = begin;
                continue;
            }
            now.next = nodes.pollLast();
            now.next.next = null;
            now = now.next;
        }
        return begin;
    }

}
