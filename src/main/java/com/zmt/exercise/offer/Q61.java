package com.zmt.exercise.offer;

import java.util.Arrays;

public class Q61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroNum = 0;
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) zeroNum++;
            if (i != 0 && nums[i] != 0 && nums[i] == nums[i - 1]) return false;
        }
        if (zeroNum == 0 && nums[4] - nums[0] == 4) return true;
        if (zeroNum > 0 && nums[4] - nums[zeroNum] <= 4) return true;
        return false;
    }
    public int add(int a, int b) {
        return Math.addExact(a,b);
    }
}
