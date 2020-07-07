package com.zmt.exercise.offer;

public class Q12 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }
        boolean result = false;
        int row = board.length;
        int column = board[0].length;
        int[][] status = new int[row][column];
        char[] chars = word.toCharArray();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result = find(board, status, i, j, chars, 0, row, column);
                if (result) {
                    return result;
                }
            }
        }
        return false;
    }

    public boolean find(char[][] board, int[][] status, int x, int y, char[] words, int position, int row, int column) {
        if (x < 0 || x >= row || y < 0 || y >= column || status[x][y] == 1 || board[x][y] != words[position]) {
            return false;
        }
        status[x][y] = 1;
        boolean result = false;
        result = find(board, status, x + 1, y, words, position + 1, row, column) |
                find(board, status, x - 1, y, words, position + 1, row, column) |
                find(board, status, x, y - 1, words, position + 1, row, column) |
                find(board, status, x, y + 1, words, position + 1, row, column);
        if (!result) {
            status[x][y] = 0;
        }
        return result;

    }

}
