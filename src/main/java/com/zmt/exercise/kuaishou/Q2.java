package com.zmt.exercise.kuaishou;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentNumber = scanner.nextInt();
        int questionNumber = scanner.nextInt();
        String[] values = new String[studentNumber];
        int[] score = new int[questionNumber];
        for (int i = 0; i < studentNumber; i++) {
            values[i] = scanner.next();
        }
        for (int i = 0; i < questionNumber; i++) {
            score[i] = scanner.nextInt();
        }
        int[][] select = new int[questionNumber][5];

        for (int i = 0; i < studentNumber; i++) {
            for (int j = 0; j < questionNumber; j++) {
                select[j][values[i].charAt(j) - 'A']++;
            }
        }
        int max = 0;
        for (int i = 0; i < questionNumber; i++) {
            int now = 0;
            for (int j = 0; j < 5; j++) {
                now = Math.max(now, select[i][j]);
            }
            max += now * score[i];
        }

        System.out.println(max);

    }
}
