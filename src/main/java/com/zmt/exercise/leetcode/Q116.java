package com.zmt.exercise.leetcode;

import java.util.LinkedList;

public class Q116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        LinkedList<Node> linkedList = new LinkedList<>();
        LinkedList<Integer> hegiht = new LinkedList<>();
        if(root!= null){
            linkedList.addFirst(root);
            hegiht.addFirst(1);

        }
        while (!linkedList.isEmpty()){
            Node temp = linkedList.pollFirst();
            Integer integer = hegiht.pollLast();
            while (hegiht.peekFirst() !=null && hegiht.peekFirst() == integer){
                addTemp(linkedList,hegiht,temp,integer);
                temp.next = linkedList.peekFirst();
                temp = linkedList.pollFirst();
                integer = hegiht.pollFirst();
            }
            addTemp(linkedList,hegiht,temp,integer);

        }

        return root;
    }

    void addTemp(LinkedList<Node> linkedList,LinkedList<Integer> hegiht,Node temp,Integer h){
        if(temp == null) return;
        if(temp.left!= null){
            linkedList.addLast(temp.left);
            hegiht.add(h+1);
        }
        if(temp.right!= null){
            linkedList.addLast(temp.right);
            hegiht.add(h+1);
        }
    }
}
