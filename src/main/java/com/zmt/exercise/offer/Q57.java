package com.zmt.exercise.offer;

import java.util.ArrayList;
import java.util.List;

public class Q57 {
    public int[] twoSum(int[] nums, int target) {
        int before = 0;
        int end = nums.length - 1;
        while (before < end) {
            if (nums[before] + nums[end] > target) {
                end--;
            } else if (nums[before] + nums[end] < target) {
                before++;
            } else {
                int[] result = new int[2];
                result[0] = before;
                result[1] = end;
                return result;
            }
        }
        return new int[0];
    }
    class Node{
        int begin;
        int end;
        public Node(int begin,int end){
            this.begin = begin;
            this.end = end;
        }
    }
    public int[][] findContinuousSequence(int target) {
        List<Node> list = new ArrayList<>();
        int begin = 1;
        int end = 2;
        while(begin < end && end < target/2 +1){
            if( (begin + end) * (end - begin + 1) == target * 2){
                list.add(new Node(begin,end));
                begin++;
                end++;
            }else if( (begin + end) * (end - begin + 1) > target * 2){
                begin++;
            }else{
                end++;
            }
        }
        if(list.size() == 0) return new int[0][0];
        Node first = list.get(0);
        int[][] result = new int[list.size()][first.end - first.begin+1];
        Node temp;
        for(int i = 0; i < list.size(); i++){
            temp = list.get(i);
            for(int j = temp.begin; j <= temp.end; j++ ){
                result[i][j-temp.begin] = j;
            }
        }
        return result;

    }
}
