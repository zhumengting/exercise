package com.zmt.exercise.leetcode;

import java.util.HashSet;

public class Q125 {
    public boolean isPalindrome(String s) {
        char temp;
        s = s.toLowerCase();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            temp = s.charAt(i);
            if((temp >= '0' && temp <= '9') || (temp >= 'a' && temp <='z')){
                if(set.contains(temp)){
                    set.remove(temp);
                }else{
                    set.add(temp);
                }
            }
        }

        if(set.size() <= 1) return true;
        return false;
    }
}
