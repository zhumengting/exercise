package com.zmt.exercise.leetcode;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class Node {
        int key;
        int val;
        Node next;
        Node before;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node begin;
    private Node end;
    private Map<Integer, Node> map;
    private int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        begin = new Node(-1, -1);
        end = new Node(-1, -1);
        begin.next = end;
        begin.before = end;
        end.next = begin;
        end.before = begin;
    }

    public int get(int key) {
        Node temp;
        if (map.size() == 0 || (temp = map.get(key)) == null) return -1;
        put(key,temp.val);
        return temp.val;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (!map.containsKey(key)) {
            if (map.size() >= capacity) {
                removeBegin();
            }

        } else {
            node = map.get(key);
            node.val = value;
            node.next.before = node.before;
            node.before.next = node.next;

        }
        putToEnd(node);
        map.put(key, node);
    }

    public void putToEnd(Node node){
        end.before.next = node;
        node.next = end;
        node.before = end.before;
        end.before = node;
    }
    public void removeBegin(){
        map.remove(begin.next.key);
        begin.next.next.before = begin;
        begin.next = begin.next.next;
    }
}
