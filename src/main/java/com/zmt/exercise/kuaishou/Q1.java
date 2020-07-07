package com.zmt.exercise.kuaishou;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String val = scanner.next();
        int result = 0;
        char[] strs = val.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == '1') {
                list.add(i);
            }
        }

        if(number == 0){
            if(list.size() == 0 && strs.length != 0){
                System.out.println(factorial(strs.length));
                return;
            }
            for(int i = 0; i < list.size(); i++){
                if(i == 0) result += list.get(i) > 0 ? factorial(list.get(i)):0;
                if(i == list.size()-1) result += strs.length-1-list.get(i) > 0 ? factorial(strs.length-1-list.get(i)):0;
                if(i >= 0 && i < list.size()-1) result += list.get(i+1)-1-list.get(i) > 0 ? factorial(list.get(i+1)-1-list.get(i)):0;
            }
            System.out.println(result);
            return;
        }
        int begin;
        int end;
        for (int i = 0; i <= list.size() - number; i++) {
            if (i == 0) begin = 0;
            else begin = list.get(i - 1) + 1;
            if (i == list.size() - number) end = strs.length - 1;
            else end = list.get(i + number) - 1;
            int left = list.get(i) - begin <= 0 ? 1 : list.get(i) - begin + 1;
            int right = end - list.get(i + number-1) <= 0 ? 1 :end - list.get(i + number-1) + 1;

            result += left * right;
        }

        System.out.println(result);
    }

    public static int factorial(int number) {
        if (number <= 1)
            return 1;
        else
            return number + factorial(number - 1);
    }
}
