package com.zmt.exercise.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q37 {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            TreeNode node = linkedList.pollFirst();
            if (node != null) {
                list.add(node.val);
                linkedList.addLast(node.left);
                linkedList.addLast(node.right);
            } else {
                list.add(null);
            }
        }
        while (!list.isEmpty() && list.peekLast() == null) {
            list.pollLast();
        }
        return list.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] list = data.replace("[", "").replace("]", "").split(",");
        LinkedList<TreeNode> waitLIst = new LinkedList<>();
        if (list.length == 0 || list[0].equals("")) {
            return null;
        }
        int position = 0;
        TreeNode root = new TreeNode(Integer.parseInt(list[position]));
        waitLIst.add(root);
        while (!waitLIst.isEmpty()) {
            TreeNode node = waitLIst.pollFirst();
            node.left = generatorNode(list, ++position);
            if (node.left != null) waitLIst.add(node.left);
            node.right = generatorNode(list, ++position);
            if (node.right != null) waitLIst.add(node.right);
        }
        return root;
    }

    private static TreeNode generatorNode(String[] list, int position) {
        if (position >= list.length || list[position].equals("null")) {
            return null;
        }
        return new TreeNode(Integer.parseInt(list[position]));
    }

    public static void main(String[] args) {
        String val = "[]";
        TreeNode node = deserialize(val);
        System.out.println(serialize(node));
    }

}
