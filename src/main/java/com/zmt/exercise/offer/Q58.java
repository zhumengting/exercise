package com.zmt.exercise.offer;

import java.util.Arrays;

public class Q58 {
    public static String reverseWords(String s) {
        String[] values = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = values.length- 1; i >= 0; i--){
            if(values[i].equals("")) continue;
            stringBuilder.append(values[i].trim());
            if(i != 0) stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        String str = "hello     my word";
        System.out.println(reverseWords(str));
    }
}
