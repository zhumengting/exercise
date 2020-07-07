package com.zmt.exercise.leetcode;

import java.util.*;

public class Q128 {
    static class Node {
        int begin;
        int end;

        public Node() {
        }

        public Node(int begin, int end) {
            this.begin = begin;
            this.end = end;

        }
    }

    public static void main(String[] args) {
        int[] nums = {4,2,2,-4,0,-2,4,-3,-4,-4,-5,1,4,-9,5,0,6,-8,-1,-3,6,5,-8,-1,-5,-1,2,-9,1};
        System.out.println(longestConsecutive(nums));
    }

    public static  int longestConsecutive(int[] nums) {
        HashMap<Integer, Node> beginMap = new HashMap<>();
        HashMap<Integer, Node> endMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (beginMap.containsKey(nums[i] + 1) && endMap.containsKey(nums[i] - 1)) {
                //end + now + begin = new
                Node beginNode = beginMap.get(nums[i] + 1);
                Node endNode = endMap.get(nums[i] - 1);
                Node newNode = new Node(endNode.begin,beginNode.end);
                //重新插入
                beginMap.remove(beginNode.begin);
                beginMap.remove(endNode.begin);
                beginMap.put(newNode.begin,newNode);
                endMap.remove(beginNode.end);
                endMap.remove(endNode.end);
                endMap.put(newNode.end,newNode);

            } else if (endMap.containsKey(nums[i] - 1)) {
                Node endNode = endMap.get(nums[i] - 1);
                endNode.end = nums[i];
                endMap.remove(nums[i] - 1);
                if(!endMap.containsKey(nums[i])|| endMap.get(nums[i]).begin > endNode.begin ){
                    endMap.put(nums[i],endNode);
                    Node beginNode = beginMap.get(endNode.begin);
                    beginNode.end = nums[i];
                }

            } else if(beginMap.containsKey(nums[i] + 1)){
                Node beginNode = beginMap.get(nums[i] + 1);
                beginNode.begin = nums[i];
                beginMap.remove(nums[i] + 1);
                if(!beginMap.containsKey(nums[i])|| beginMap.get(nums[i]).end < beginNode.end ){
                    beginMap.put(nums[i],beginNode);
                    Node endNode = endMap.get(beginNode.end);
                    endNode.begin = nums[i];
                }

            }else {
                Node node = new Node(nums[i], nums[i]);
                if(!beginMap.containsKey(nums[i]) && !endMap.containsKey(nums[i])){
                    beginMap.put(nums[i], node);
                    endMap.put(nums[i], node);
                }
            }
        }
        Iterator<Map.Entry<Integer, Node>> iterator = beginMap.entrySet().iterator();
        int max = 0;
        while(iterator.hasNext()){
            Map.Entry<Integer, Node> next = iterator.next();
            Node node = next.getValue();
            max=Math.max(max,node.end - node.begin + 1);
        }
        return  max;
    }
}
