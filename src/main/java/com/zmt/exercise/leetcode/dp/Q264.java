package com.zmt.exercise.leetcode.dp;

import java.util.ArrayList;
import java.util.TreeSet;

public class Q264 {
    public static int nthUglyNumber(int n) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        while (n > 1) {
            int x = set.pollFirst();
            System.out.println(x);
            if (x < Integer.MAX_VALUE / 2) set.add(2 * x);
            if (x < Integer.MAX_VALUE / 3) set.add(3 * x);
            if (x < Integer.MAX_VALUE / 5) set.add(5 * x);
            n--;
        }
        return set.pollFirst();

    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1690));
        System.out.println(nthUglyNumber2(1690));
    }

    public static int nthUglyNumber2(int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        int two = 0;
        int three = 0;
        int five = 0;
        int min = 0;
        while (arrayList.size() < n) {
            min = Math.min(arrayList.get(two) * 2, arrayList.get(three) * 3);
            min = Math.min(arrayList.get(five) * 5, min);
            if (arrayList.get(two) * 2 == min) two++;
            if (arrayList.get(three) * 3 == min) three++;
            if (arrayList.get(five) * 5 == min) five++;
            arrayList.add(min);
        }
        return arrayList.get(n - 1);

    }

}
