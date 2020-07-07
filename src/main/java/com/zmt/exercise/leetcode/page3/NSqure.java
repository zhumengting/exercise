package com.zmt.exercise.leetcode.page3;

public class NSqure {
    public static int[][] generateMatrix(int n) {
        int[][] status = new int[n][n];
        int[][] result = new int[n][n];
        int pos = 0;
        findPosition(result, status, 0, -1, n, pos, 1);
        return result;
    }

    public static int[][] findPosition(int[][] result, int[][] status, int x, int y, int n, int pos, int number) {
        if (number > n * n) {
            return result;
        }
        switch (pos) {
            case 0:
                y++;
                break;
            case 1:
                x++;
                break;
            case 2:
                y--;
                break;
            case 3:
                x--;
                break;
        }
        if (y < n && y >= 0 && x < n && x >= 0 && status[x][y] == 0) {
            status[x][y] = 1;
            result[x][y] = number;

        } else {
            switch (pos) {
                case 0:
                    y--;
                    break;
                case 1:
                    x--;
                    break;
                case 2:
                    y++;
                    break;
                case 3:
                    x++;
                    break;
            }
            pos = (pos + 1) % 4;
            return findPosition(result, status, x, y, n, pos, number);
        }
        number++;
        return findPosition(result, status, x, y, n, pos, number);

    }

    public static void main(String[] args) {
        generateMatrix(2);

    }
}
