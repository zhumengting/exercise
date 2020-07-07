package com.zmt.exercise.leetcode.page3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Combine {
    private static int row = 0;
    private static int column = 0;

    public static boolean exist(char[][] board, String word) {
        row = board.length;
        if (row == 0 || word.length() == 0) {
            return false;
        }
        column = board[0].length;
        if (column == 0) {
            return false;
        }
        int[][] status = new int[row][column];

        boolean isFind = false;
        char first = word.charAt(0);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == first) {
                    isFind = findExist(status, board, word, i, j, 1);
                    if (isFind) {
                        return isFind;
                    }
                }
            }
        }
        return isFind;
    }

    public static boolean findExist(int[][] status, char[][] board, String word, int x, int y, int pos) {
        //停止条件
        if (pos == word.length()) {
            return true;
        }
        boolean isFind = false;

        status[x][y] = 1;

        //dfs
        if (!isFind && check(status, board, x, y + 1, word.charAt(pos))) {
            isFind = findExist(status, board, word, x, y + 1, pos + 1);
        }
        if (!isFind && check(status, board, x, y - 1, word.charAt(pos))) {
            isFind = findExist(status, board, word, x, y - 1, pos + 1);
        }
        if (!isFind && check(status, board, x + 1, y, word.charAt(pos))) {
            isFind = findExist(status, board, word, x + 1, y, pos + 1);
        }
        if (!isFind && check(status, board, x - 1, y, word.charAt(pos))) {
            isFind = findExist(status, board, word, x - 1, y, pos + 1);
        }
        if (!isFind) {
            status[x][y] = 0;
        }
        return isFind;

    }

    private static boolean check(int[][] status, char[][] board, int x, int y, char a) {
        if (x >= row || x < 0 || y >= column || y < 0) {
            return false;
        }
        if (board[x][y] == a && status[x][y] != 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Pattern p = Pattern.compile("a*b");
        Matcher m = p.matcher("aaaaab");
        boolean b = m.matches();
        System.out.println(b);

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<String> restoreIpAddressesDfs(int begin, String s, int index) {
        List<String> result = new ArrayList();
        if (check(begin, s, index) == false) return null;
        if (index == 1) {
            int val = Integer.parseInt(s.substring(begin, s.length()));
            if (val < 256) {
                result.add(String.valueOf(val));
            }
        }
        for (int i = 1; i <= 3; i++) {
            List<String> temp = restoreIpAddressesDfs(begin + i, s, index - 1);
            if (temp == null) continue;
            for (int j = 0; j < temp.size(); j++) {
                StringBuilder str = new StringBuilder();
                str.append(s.substring(begin, begin + i) + ".");
                str.append(temp.get(j));
                result.add(str.toString());
            }
        }

        return result;
    }

    public static boolean check(int begin, String s, int index) {
        if (s.length() - begin > index * 3 || s.charAt(begin) > '2' || s.length() - begin < index) {
            return false;
        }
        return true;
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList();
        if (n == 0) {
            return result;
        }
        result.add(0);
        result.add(1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < result.size(); j++) {
                stack.push(result.get(j));
            }
            while (!stack.empty()) {
                result.add((int) Math.pow(2, i - 1) + stack.pop());
            }
        }

        return result;
    }
}
