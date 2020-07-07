package com.zmt.exercise.tx;

import java.util.LinkedList;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int couple = scanner.nextInt();
        for (int i = 0; i < couple; i++) {
            int size = scanner.nextInt();
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) {
                String text = scanner.next();
                if ("PUSH".equals(text)) list.add(scanner.nextInt());
                else if ("TOP".equals(text)) System.out.println(list.peekFirst() == null ? -1 : list.peekFirst());
                else if ("POP".equals(text) && list.pollFirst() == null) System.out.println(-1);
                else if ("SIZE".equals(text)) System.out.println(list.size());
                else if ("CLEAR".equals(text)) list.clear();
            }
        }
    }
}
