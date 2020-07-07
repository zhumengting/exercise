package com.zmt.exercise.offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Q56 {
    public int[] singleNumbers(int[] nums) {
        int value = 0;
        for (int i = 0; i < nums.length; i++) {
            value = value ^ nums[i];
        }
        int mask = 1;
        while ((mask & value) == 0) {
            mask <<= 1;
        }
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if ((mask & nums[i]) == 1) {
                result[0] = result[0] ^ nums[i];
            } else {
                result[1] = result[1] ^ nums[i];
            }
        }
        return result;
    }

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer val;
            if ((val = map.get(nums[i])) == null) {
                val = 0;
            } else if (val == 2) {
                map.remove(nums[i]);
                continue;
            }
            map.put(nums[i], val + 1);
        }

        for(Integer val : map.values()){
            return val;
        }
        return -1;

    }
}
