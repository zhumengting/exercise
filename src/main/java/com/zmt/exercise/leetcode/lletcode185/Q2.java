package com.zmt.exercise.leetcode.lletcode185;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        minNumberOfFrogs("crocracokrakoak");
        Stack<Integer> min = new Stack<>();

    }

    public static int minNumberOfFrogs(String croakOfFrogs) {
        int[] status = new int[croakOfFrogs.length()];
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            if (croakOfFrogs.charAt(i) == 'c') {
                status[i] = 1;
                int end = check(status, croakOfFrogs, 1, i + 1);
                if (end == -1) {
                    return -1;
                }
                List<Integer> couple = new ArrayList<>();
                couple.add(i);
                couple.add(end);
                lists.add(couple);
            }
        }
        for (int i = 0; i < status.length; i++) {
            if (status[i] == 0) {
                return -1;
            }
        }
        for (int i = 1; i < lists.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (lists.get(i).get(0) > lists.get(j).get(1)) {
                    int end = lists.get(i).get(1);
                    lists.get(j).set(1, end);
                    lists.remove(lists.get(i));
                    break;
                }
            }
        }
        return lists.size();
    }

    public static int check(int[] status, String croak, int index, int now) {
        if (now >= croak.length()) {
            return -1;
        }
        if (status[now] == 1) {
            return check(status, croak, index, now + 1);
        }

        if ((index == 1 && croak.charAt(now) == 'r') || (index == 2 && croak.charAt(now) == 'o') ||
                (index == 3 && croak.charAt(now) == 'a')) {
            status[now] = 1;
            return check(status, croak, index + 1, now + 1);
        }
        if ((index == 1 && croak.charAt(now) != 'r') || (index == 2 && croak.charAt(now) != 'o') ||
                (index == 3 && croak.charAt(now) != 'a') || (index == 4 && croak.charAt(now) != 'k')) {
            return check(status, croak, index, now + 1);
        }

        if (index == 4 && croak.charAt(now) == 'k') {
            status[now] = 1;
            return now;
        }
        return -1;
    }
}
