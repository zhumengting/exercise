package com.zmt.exercise.leetcode.tree;

import com.zmt.exercise.offer.TreeNode;

import java.util.*;

public class Q103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> high = new LinkedList<>();
        if (root == null) return result;
        queue.add(root);
        high.add(0);
        int level_before = 0;
        int val = 0;
        int level = 0;
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty() && !high.isEmpty()) {
            TreeNode now = queue.poll();
            val = now.val;
            level = high.poll();
            if (now.left != null) {
                queue.add(now.left);
                high.add(level + 1);
            }
            if (now.right != null) {
                queue.add(now.right);
                high.add(level + 1);
            }
            if (level != level_before) {
                if (level_before % 2 == 1) Collections.reverse(list);
                level_before = level;
                result.add(list);
                list = new ArrayList<>();
                list.add(val);
            } else {
                list.add(val);
            }
        }
        if (level % 2 == 1) Collections.reverse(list);
        result.add(list);
        return result;

    }

    private void addQueue(TreeNode root, Queue<Integer> queue, Queue<Integer> high, int level) {
        if (root == null) return;
        queue.add(root.val);
        high.add(level);
        addQueue(root.left, queue, high, level + 1);
        addQueue(root.right, queue, high, level + 1);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        LinkedList<Integer> high = new LinkedList<>();
        if (root == null) return result;
        linkedList.add(root);
        high.add(0);
        TreeNode now = null;
        int level = 0;
        int level_before = 0;
        List<Integer> list = new ArrayList<>();
        while (!linkedList.isEmpty()) {
            now = linkedList.pollFirst();
            level = high.pollFirst();
            if (now.left != null) {
                linkedList.add(now.left);
                high.add(level + 1);
            }
            if (now.right != null) {
                linkedList.add(now.right);
                high.add(level + 1);
            }
            if (level != level_before) {
                level_before = level;
                result.addFirst(list);
                list = new ArrayList<>();
                list.add(now.val);
            } else {
                list.add(now.val);
            }
        }
        result.addFirst(list);
        return result;
    }
}
