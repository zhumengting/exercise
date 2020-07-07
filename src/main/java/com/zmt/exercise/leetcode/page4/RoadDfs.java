package com.zmt.exercise.leetcode.page4;

public class RoadDfs {
    public static int uniquePaths(int m, int n) {
        return dfs(m - 1, n - 1);
    }

    public static int dfs(int m, int n) {
        int result = 0;
        if (m == 0 && n == 0) {
            result += 1;
        }
        if (m < 0) {
            return result;
        }
        if (n < 0) {
            return result;
        }
        result += dfs(m - 1, n);
        result += dfs(m, n - 1);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));

    }
}
