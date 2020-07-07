package com.zmt.exercise.offer;

public class Q53 {
    public static int missingNumber(int[] nums) {
        if(nums.length == 1 && nums[0] == 1) return 0;
        if(nums.length == 1 && nums[0] == 0) return 1;
        return find(nums,0,nums.length - 1);
    }
    public static int find(int[] nums,int begin,int end){
        if(end == begin + 1){
            for(int i = nums[begin]; i<= nums[end]; i++){
                if(i != nums[begin] && i != nums[end]) return i;
            }
        }
        int mid = (begin+end)/2;
        if(nums[mid] > (begin+end+1)/2) return find(nums,begin,mid);
        return find(nums, mid, end);
    }

    public static void main(String[] args) {
        int[] val = {0,1,3};
        missingNumber(val);
    }
}
