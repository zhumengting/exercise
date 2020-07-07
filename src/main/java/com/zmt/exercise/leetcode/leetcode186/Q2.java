package com.zmt.exercise.leetcode.leetcode186;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q2 {
    public int maxScore(int[] cardPoints, int k) {
        int beforePos = k - 1;
        int endPos = cardPoints.length - k;
        while (k > 0) {
            k--;
            if (cardPoints[endPos] < cardPoints[beforePos]) {
                endPos++;
            } else {
                beforePos--;
            }
        }
        int max = 0;
        for (int i = 0; i <= beforePos; i++) {
            max += cardPoints[i];
        }
        for (int i = endPos; i < cardPoints.length; i++) {
            max += cardPoints[i];
        }
        return max;

    }

    public int find(int[] cardPoints, int k, int before, int end, int now) {
        if (k == 0) {
            return now;
        }
        if (k == 1) {
            return now + Math.max(cardPoints[before], cardPoints[end]);
        }
        return Math.max(find(cardPoints, k - 1, before + 1, end, cardPoints[before]), find(cardPoints, k - 1, before, end - 1, cardPoints[end]));

    }
}
