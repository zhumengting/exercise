package com.zmt.exercise.leetcode;

import java.util.*;

public class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if(i!= 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if(j!= i + 1 && nums[j] == nums[j-1]) continue;
                if (nums[i] + nums[j] > 0) break;
                if (((-nums[i] - nums[j] > nums[j]) || (-nums[i] - nums[j] == nums[j] && j < nums.length - 1 && -nums[i] - nums[j] == nums[j + 1]))
                        && set.contains(-nums[i] - nums[j])) {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(nums[i]);
                    newList.add(nums[j]);
                    newList.add(-nums[i] - nums[j]);
                    result.add(newList);
                }
            }
        }
        return  result;
    }
}
