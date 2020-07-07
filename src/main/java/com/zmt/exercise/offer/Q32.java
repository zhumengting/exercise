package com.zmt.exercise.offer;

import java.util.*;

public class Q32 {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.right = new TreeNode(8);
        levelOrder(t);
    }

    public static int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return new int[0];
        }
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        TreeNode temp = null;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            list.add(temp.val);
            if (temp.left != null) queue.offer(temp.left);
            if (temp.right != null) queue.offer(temp.right);
        }
        int[] value = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            value[i] = list.get(i);
        }
        return value;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> results = new ArrayList();
        Queue<TreeNode> treeQueue = new LinkedList();
        Queue<Integer> indexQueue = new LinkedList();
        if (root == null) {
            return results;
        }
        treeQueue.offer(root);
        indexQueue.offer(0);

        while (!treeQueue.isEmpty()) {
            TreeNode t = treeQueue.poll();
            int index = indexQueue.poll();
            List<Integer> item = null;
            if (results.size() <= index) {
                if (index % 2 == 0 && index != 0) {
                    List<Integer> reverse = results.get(results.size() - 1);
                    results.remove(results.size() - 1);
                    Collections.reverse(reverse);
                    results.add(reverse);
                }
                item = new ArrayList();
                item.add(t.val);
                results.add(item);
            } else {
                item = results.get(index);
                item.add(t.val);
            }
            if (t.left != null) {
                treeQueue.offer(t.left);
                indexQueue.offer(index + 1);
            }
            if (t.right != null) {
                treeQueue.offer(t.right);
                indexQueue.offer(index + 1);
            }
        }
        return results;
    }
}
