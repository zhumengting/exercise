package com.zmt.exercise.xiaohongshu;


import java.util.Scanner;
import java.util.Stack;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String val = scanner.next();
        Stack<Character> characters = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < val.length(); i++){
            if(val.charAt(i) == '('){
                characters.push('(');

            }else if(val.charAt(i) == ')'){
                characters.pop();

            } else if(!characters.isEmpty()) continue;
            else if(val.charAt(i) == '<')stringBuilder.deleteCharAt(stringBuilder.length()-1);
            else stringBuilder.append(val.charAt(i));
        }

        System.out.println(stringBuilder.toString());


    }
}
