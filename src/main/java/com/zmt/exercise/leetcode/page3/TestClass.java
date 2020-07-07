package com.zmt.exercise.leetcode.page3;

import java.util.Scanner;

public class TestClass {
    static int row;
    static int column;
    static int beginx = 0, beginy = 0, endx = 0, endy = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        column = scanner.nextInt();
        String[][] matrix = new String[row][column];
        int[][] state = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = scanner.next();
                if ("s".equals(matrix[i][j])) {
                    beginx = i;
                    beginy = j;
                }
                if ("e".equals(matrix[i][j])) {
                    endx = i;
                    endy = j;
                }

            }
        }
        System.out.println(searchDfs(beginx, beginy, state, matrix, 5));

    }

    public static int searchDfs(int x, int y, int[][] state, String[][] matrix, int jump) {
        int result = Integer.MAX_VALUE;
        if (!check(x, y, state, matrix, jump)) {
            return result;
        }
        if (x == endx && y == endy) {
            return 0;
        }

        state[x][y] = 1;
        result = Math.min(searchDfs(x + 1, y, state, matrix, jump),
                searchDfs(x - 1, y, state, matrix, jump));
        result = Math.min(result, searchDfs(x, y + 1, state, matrix, jump));
        result = Math.min(result, searchDfs(x, y - 1, state, matrix, jump));
        result = Math.min(result, searchDfs(row - 1 - x, column - 1 - y, state, matrix, jump - 1));

        result = result == Integer.MAX_VALUE ? result : result + 1;
        state[x][y] = 0;

        return result;
    }

    public static boolean check(int x, int y, int[][] state, String[][] matrix, int jump) {
        if (jump >= 0 && x < row && x >= 0 && y < column && y >= 0 && state[x][y] == 0 && !"#".equals(matrix[x][y])) {
            return true;
        }
        return false;
    }

}
