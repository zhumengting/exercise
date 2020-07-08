package com.zmt.exercise.leetcode;

import com.zmt.exercise.offer.TreeNode;

public class Q129 {
    public int sumNumbers(TreeNode root) {
        return count(root, 0);
    }

    public int count(TreeNode root, int now) {
        if (root == null) return now;
        now = now * 10 + root.val;
        int result = 0;
        if (root.left == null && root.right == null) return now;
        if (root.left != null) result += count(root.left, now);
        if (root.right != null) result += count(root.right, now);
        return result;
    }
}
