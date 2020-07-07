package com.zmt.exercise.leetcode;

public class Q87 {
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2))
            return true;
        boolean result = false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(int i=0;i<s1.length();i++){
            count1[s1.charAt(i)-'a']++;
            count2[s2.charAt(i)-'a']++;
        }
        for(int i=0;i<count1.length;i++){
            if(count1[i]!=count2[i])
                return false;
        }
        for(int i=1;i<s1.length();i++){
            if(isScramble(s1.substring(0,i), s2.substring(0,i))&&
                    isScramble(s1.substring(i,s1.length()), s2.substring(i,s1.length()))){
                return true;
            };
        }
        for(int i=1;i<s1.length();i++){
            if(isScramble(s1.substring(0,i), s2.substring(s1.length()-i,s1.length()))&&
                    isScramble(s1.substring(i,s1.length()), s2.substring(0,s1.length()-i))){
                return true;
            };
        }
        return false;
    }
}
