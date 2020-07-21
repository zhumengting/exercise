package com.zmt.exercise.leetcode;

import java.util.LinkedList;

public class Q135 {
    public int candy(int[] ratings) {
        LinkedList<Integer> increase = new LinkedList<>();
        LinkedList<Integer> decrease = new LinkedList<>();

        for (int i = 0; i < ratings.length; i++) {
            if (increase.size() == 0 && decrease.size() == 0) increase.add(ratings[i]);
            else if (ratings[i] > ratings[i - 1] && decrease.size() == 0) increase.add(ratings[i]);
            else if (ratings[i] > ratings[i - 1]) {

            } else decrease.add(ratings[i]);
        }
        return -1;

    }
}
