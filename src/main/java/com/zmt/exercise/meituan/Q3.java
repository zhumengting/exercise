package com.zmt.exercise.meituan;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean[] binansuo = new boolean[n];
        int op = 0;
        int pos = 0;
        for (int i = 0; i < m; i++) {
            op = scanner.nextInt();
            pos = scanner.nextInt();
            if (op == 1) binansuo[pos - 1] = true;
            else {
                if(pos-1 >= binansuo.length){
                    System.out.println(-1);
                    continue;
                }
                if(!binansuo[pos-1]){
                    System.out.println(pos);
                    continue;
                }
                while (pos-1 < binansuo.length && binansuo[pos-1]) {
                    pos++;
                }
                if (pos >= binansuo.length+1) System.out.println(-1);
                else System.out.println(pos);
            }
        }
    }

}
