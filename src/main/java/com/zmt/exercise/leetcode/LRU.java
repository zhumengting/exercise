package com.zmt.exercise.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    public static void main(String[] args) {

    }

    class LRUCache {
        class Node<K, V> {
            Node<K, V> before;
            Node<K, V> after;
            K key;
            V value;
        }

        private int capacity;
        Node begin;
        Node tail;
        Map<Integer, Node<Integer, Integer>> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            begin = new Node();
            tail = begin;
        }

        public int get(int key) {
            Node node;
            if ((node = map.get(key)) == null) {
                return -1;
            }
            putToLast(key);
            return (int) node.value;
        }

        public void put(int key, int value) {

            if (map.get(key) == null) {
                if (map.size() >= value) {
                    int k = (int) begin.key;
                    map.remove(k);
                    begin.before.after = begin.after;
                    begin.after.before = begin.before;
                    begin = begin.after;
                }
                Node<Integer, Integer> newNode = new Node<>();
                newNode.key = key;
                newNode.value = value;
                newNode.before = tail;
                newNode.after = begin;
                newNode.before.after = newNode;
                newNode.after.before = newNode;
                tail = newNode;
                if(map.size() == 0) begin = newNode;

                map.put(key, newNode);
            } else {
                putToLast(key);
            }
        }

        public void putToLast(int key) {
            Node<Integer, Integer> newNode = map.get(key);
            newNode.before.after = newNode.after;
            newNode.after.before = newNode.before;
            map.remove(key);
            newNode.before = tail;
            newNode.after = begin;
            newNode.before.after = newNode;
            newNode.after.before = newNode;
            tail = newNode;
        }
    }

}
