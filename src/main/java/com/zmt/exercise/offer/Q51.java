package com.zmt.exercise.offer;

public class Q51 {
    public static int reversePairs(int[] nums) {
        if(nums.length <= 1) return 0;
        int[] result = new int[nums.length];
        int[] begin = new int[nums.length];
        result[nums.length -1] = 0;
        begin[nums.length -1] = 0;
        for(int i = nums.length-2; i >= 0; i--){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] > nums[j]){
                    begin[i] = 1 + begin[j];
                    break;
                }
            }
            result[i] += result[i+1];
        }
        return result[0];
    }

    public static void main(String[] args) {
        int[] val = {8,5,4,3,7,8,9,0,34,3,100};
        reversePairs(val);
    }
}
