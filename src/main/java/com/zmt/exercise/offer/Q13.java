package com.zmt.exercise.offer;

public class Q13 {
    public static void main(String[] args) {

    }

    public static int dfs(int x, int y, int m, int n, int k, int[][] status) {
        if (x < 0 || x >= m || y < 0 || y >= n || status[x][y] == 1) {
            return 0;
        }
        if (sum(x) + sum(y) > k) {
            return 0;
        }
        status[x][y] = 1;
        return 1 + dfs(x - 1, y, m, n, k, status) + dfs(x + 1, y, m, n, k, status) + dfs(x, y - 1, m, n, k, status) + dfs(x, y + 1, m, n, k, status);
    }

    public static int sum(int x) {
        int val = 0;
        while (x / 10 != 0 || x % 10 != 0) {
            val += x % 10;
            x = x / 10;
        }
        return val;
    }
}
