package com.zmt.exercise.xiaohongshu;

import java.util.Arrays;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalVal = scanner.nextInt();
        String val = scanner.next();
        if(val.length() == 2) {
            System.out.println(0);
            return;
        }

        String[] list = val.replace("[","").replace("]","").split(",");
        int[] score = new int[list.length];
        for(int i = 0; i < list.length; i++){
            score[i] = Integer.parseInt(list[i]);
        }
        Arrays.sort(score);
        System.out.println(count(score,0,totalVal));

    }

    public static int count(int[] val,int begin,int total){
        int sum = 0;
        for(int i = begin; i < val.length; i++){
            if(val[i] == total) sum+=1;
            else if(val[i] > total) break;
            else sum += count(val,i,total-val[i]);
        }
        return sum;
    }
}
