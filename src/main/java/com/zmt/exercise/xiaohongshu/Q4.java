package com.zmt.exercise.xiaohongshu;

import java.util.Scanner;

public class Q4 {
    class Node{
        int a;
        int b;
        public Node(int a, int b){
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        for(int i = 0; i < size; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if(a>b) continue;
        }
    }
}
