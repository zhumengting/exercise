package com.zmt.exercise.leetcode.leetcode186;

import java.util.ArrayList;
import java.util.List;

public class q3 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {

        List<Integer> results = new ArrayList<>();
        int max = Math.max(nums.size(), nums.get(0).size());
        for (int i = 0; i < max; i++) {
            max = Math.max(max, i + nums.get(i).size());
            for (int j = i; j >= 0; j--) {
                if (j < nums.size() && i - j < nums.get(j).size())
                    results.add(nums.get(j).get(i - j));
            }
        }
        int[] val = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            val[i] = results.get(i);
        }
        return val;
    }

}
