package com.zmt.exercise.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q119 {
    public List<Integer> getRow(int rowIndex) {
        int[] array = new int[rowIndex+1];
        array[0] =1;
        for(int i = 1; i <= rowIndex/2; i++){
            for(int j = 1; j <= i; j++){
                array[j] = array[j] + array[j-1];
            }
        }

        for(int i = rowIndex; i > rowIndex/2;i--){
            array[i] = array[rowIndex-i];
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++){
            list.add(array[i]);
        }
        return list;

    }

}
