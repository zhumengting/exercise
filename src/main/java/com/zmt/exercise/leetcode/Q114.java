package com.zmt.exercise.leetcode;

import com.zmt.exercise.offer.TreeNode;

import java.util.LinkedList;


public class Q114 {
    public void flatten(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.addFirst(root);
        }
        while (!queue.isEmpty()){
            TreeNode temp = queue.pollFirst();
            if (temp.right != null) queue.addFirst(temp.right);
            if (temp.left != null) queue.addFirst(temp.left);
            temp.right = queue.peekFirst();
            temp.left = null;
        }
    }


}
