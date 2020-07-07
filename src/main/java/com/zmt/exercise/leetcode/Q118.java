package com.zmt.exercise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> temp;
            if (i == 1) {
                temp = new ArrayList<>();
                temp.add(1);
            } else {
                temp = new ArrayList<>(i);
                for(int j = 0; j < i; j++){
                    if(j == 0){
                        temp.add(list.get(i-2).get(j));
                    }else if(j == i-1){
                        temp.add(list.get(i-2).get(j-1));
                    }else{
                        temp.add(list.get(i-2).get(j-1)+list.get(i-2).get(j));
                    }
                }
            }
            list.add(temp);
        }
        return list;
    }
}
