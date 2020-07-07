package com.zmt.exercise.offer;

public class Q14 {
    public int cuttingRope(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        if (n == 5) return 6;
        if (n == 6) return 9;
        long[] val = new long[n + 1];
        val[2] = 1L;
        val[3] = 2L;
        val[4] = 4L;
        val[5] = 6L;
        val[6] = 9L;
        for (int i = 7; i <= n; i++) {
            val[i] = Math.max(val[i - 2] * 2, val[i - 3] * 3);
        }
        return (int) (val[n] % 1000000007);
    }

}
