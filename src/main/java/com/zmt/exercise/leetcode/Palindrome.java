package com.zmt.exercise.leetcode;

import java.util.*;

public class Palindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int begin = 0;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();
        while (begin < end) {
            if ((chars[begin] > 'z' || chars[begin] < 'a') && (chars[begin] > '9' || chars[begin] < '0')) {
                begin++;
            } else if ((chars[end] > 'z' || chars[end] < 'a') && (chars[end] > '9' || chars[end] < '0')) {
                end--;
            } else if (chars[begin] == chars[end]) {
                begin++;
                end--;
            } else {
                return false;
            }
        }
        return true;

    }

    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int size = Math.min(2,nums.length/3);
        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) != null){
                map.put(nums[i],map.get(nums[i]) + 1);
            }else if( map.size() < size){
                map.put(nums[i],1);
            }else{
                Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
                while(!map.isEmpty() && iterator.hasNext()){
                    Map.Entry<Integer, Integer> next = iterator.next();
                    if(next.getValue() == 1) iterator.remove();
                    else map.put(next.getKey(),next.getValue()-1);
                }
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            result.add(iterator.next().getKey());
        }
        return result;
    }
}
