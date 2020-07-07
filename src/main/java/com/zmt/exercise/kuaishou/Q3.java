package com.zmt.exercise.kuaishou;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        TreeSet<Integer> treeSet = new TreeSet<>(Comparator.reverseOrder());
        while (number > 0) {
            number--;
            treeSet.add(scanner.nextInt());
        }
        while (treeSet.size() > 1) {
            int val = Math.abs(treeSet.pollFirst() - treeSet.pollFirst());
            if (val != 0) treeSet.add(val);
        }
        if(treeSet.size() == 0) System.out.println(0);
        else System.out.println(treeSet.pollFirst());
    }
}
