package com.zmt.exercise.offer;

public class Q44 {
    public static int findNthDigit(int n) {
        if (n <= 10) return n;
        n -= 10;
        int size = 2;
        long calculate = 9 * (long) (Math.pow(10, size - 1)) * size;
        while (n > calculate) {
            size++;
            n -= calculate;
            calculate = 9 * (long) (Math.pow(10, size - 1)) * size;
        }
        long countNumber = n / size + (long) (Math.pow(10, size - 1));
        int remain = n % size;
        return String.valueOf(countNumber).charAt(remain) - '0';
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(1000000000));
    }
}
