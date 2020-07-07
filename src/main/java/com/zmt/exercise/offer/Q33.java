package com.zmt.exercise.offer;

public class Q33 {
    public static boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }

    public static boolean verify(int[] order, int begin, int end) {
        if (begin >= end) return true;
        int find = -1;
        for (int i = begin; i < end; i++) {
            if (find == -1 && order[i] > order[end]) {
                find = i;
            }
            if (find != -1 && order[i] < order[end]) {
                return false;
            }
        }
        if (find == -1) return verify(order, begin, end - 1);
        return verify(order, begin, find - 1) && verify(order, find, end-1);

    }

    public static void main(String[] args) {
        int[]arr = {1,2,5,10,6,9,4,3};
        verifyPostorder(arr);
    }
}
