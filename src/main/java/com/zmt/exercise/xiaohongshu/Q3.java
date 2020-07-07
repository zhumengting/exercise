package com.zmt.exercise.xiaohongshu;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] likes = new int[number];
        for(int i = 0; i < number; i++){
            likes[i] = scanner.nextInt();
        }
        int[] sum = new int[number];
        int[] count = new int[number];
        for(int i = 0; i < likes.length; i++){
            if(i == 0 || (i == 1 && likes[i] >= likes[i-1])){
                sum[i] = likes[i];
                count[i] = 1;
            } else if(i == 1  || (likes[i] + sum[i-2] <= sum[i-1])){
                sum[i] = sum[i-1];
                count[i] = count[i-1];
            } else {
                sum[i] = likes[i] + sum[i-2];
                count[i] = count[i-2] + 1;
            }
        }
        System.out.println(sum[sum.length-1] + " " + count[count.length-1]);
    }
}
