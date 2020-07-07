package com.zmt.exercise.leetcode.page3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    //    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int x = scanner.nextInt();
//        int result2 = (int) ((x % (Math.pow(10, 9) + 7)) * cal(x - 1) % (Math.pow(10, 9) + 7));
//        System.out.println(result2);
//    }
    public static int cal(int n) {
        int result = 1;
        int number = n / 10 + 1;
        int remain = n % 10;
        for (int i = 0; i < number; i++) {
            if (i == number - 1) {
                result = (int) (Math.pow(2, remain) * result % (Math.pow(10, 9) + 7));
            } else {
                result = (int) (Math.pow(2, 10) * result % (Math.pow(10, 9) + 7));
            }

        }
        return result;
    }

    public static void main(String[] args) {

        int val = solution(108);
        System.out.println(val);
    }

    public static int solution(int n) {
        // write code here
        List<Integer> result = findVal(n, 2);
        return listToInt(result);
    }

    public static List<Integer> findVal(int n, int begin) {
        List<Integer> result = new ArrayList();
        if (n >= begin && n <= 9) {
            result.add(n);
            return result;
        }
        boolean find = false;
        for (int i = 9; i >= begin; i--) {
            if (n % i == 0) {
                List<Integer> temp = findVal(n / i, i);
                if (temp == null) {
                    continue;
                }
                if (find && temp.size() < result.size()) {
                    result.clear();
                } else if (find && temp.size() >= result.size()) {
                    break;
                }
                find = true;
                result.add(i);
                result.addAll(temp);
            }
        }
        if (!find) {
            return null;
        }
        return result;
    }

    public static int listToInt(List<Integer> list) {
        int val = 0;
        int number = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            val += Math.pow(10, number) * list.get(i);
            number++;
        }
        return val;
    }
}
