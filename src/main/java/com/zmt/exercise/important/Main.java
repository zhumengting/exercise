package com.zmt.exercise.important;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        LinkedList<LinkedList<Character>> result = dfs(a, a);
        while (!result.isEmpty()) {
            LinkedList<Character> characters = result.pollFirst();
            System.out.println(characters);
        }

    }

    public static LinkedList<LinkedList<Character>> dfs(int left, int right) {
        LinkedList<LinkedList<Character>> result = new LinkedList<>();
        if (left == 0) {
            LinkedList<Character> list = new LinkedList<>();
            for (int i = 0; i < right; i++) {
                list.add(')');
            }
            result.add(list);
            return result;
        }
        if (left > 0) {
            LinkedList<LinkedList<Character>> left_remain = dfs(left - 1, right);
            for (int i = 0; i < left_remain.size(); i++) {
                left_remain.get(i).addFirst('(');

            }
            result.addAll(left_remain);
        }
        if (right > 0 && right > left) {
            LinkedList<LinkedList<Character>> right_remain = dfs(left, right - 1);
            for (int i = 0; i < right_remain.size(); i++) {
                right_remain.get(i).addFirst(')');
            }
            result.addAll(right_remain);
        }
        return result;

    }

}