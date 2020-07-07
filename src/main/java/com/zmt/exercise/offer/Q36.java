package com.zmt.exercise.offer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Q36 {
    public static void main(String[] args) {
        Node n = new Node(2);
        n.left = new Node(1);
        n.right = new Node(3);
        treeToDoublyList(n);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
    }

    public static Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        LinkedList<Node> linkedList = new LinkedList<>();
        LinkedList<Boolean> check = new LinkedList<>();
        linkedList.addFirst(root);
        check.addFirst(false);
        Node begin = null;
        Node tail = begin;

        while (!linkedList.isEmpty()) {
            Node n = linkedList.pollFirst();
            boolean status = check.pollFirst();
            if (n == null) {
                continue;
            }
            if (status) {
                if (begin == null) {
                    begin = n;
                    tail = begin;
                } else {
                    tail.right = n;
                    n.left = tail;
                    tail = tail.right;
                }
                continue;
            }
            linkedList.addFirst(n.right);
            linkedList.addFirst(n);
            linkedList.addFirst(n.left);
            check.addFirst(false);
            check.addFirst(true);
            check.addFirst(false);
        }
        begin.left = tail;
        tail.right = begin;
        return begin;

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuildernull = new StringBuilder();
        stringBuilder.append("[");
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        boolean isNull = false;
        TreeNode temp = null;
        while (!treeNodes.isEmpty()) {
            temp = treeNodes.poll();
            if (temp == null) {
                isNull = true;
                stringBuildernull.append("null,");
            } else {
                if (isNull) {
                    stringBuilder.append(stringBuildernull);
                    stringBuildernull.delete(0, stringBuilder.length());
                    isNull = false;
                }
                stringBuilder.append(temp.val);
                stringBuilder.append(",");
            }
            treeNodes.add(temp.left);
            treeNodes.add(temp.right);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("]");
        return stringBuilder.toString();

    }

    // Decodes your encoded data to tree.
    /*public TreeNode deserialize(String data) {
        data = data.replace("\\[","");
        data = data.replace("\\]","");
        String[] values = data.split(",");
        if(values.length == 0){
            return null;
        }
        LinkedList<TreeNode> prepare = new LinkedList<>();

        for(int i = 0; i < )
    }*/

    /*public static Node dfs(Node root) {
        if (root.left != null) {
            Node left = dfs(root.left);
            left.right = root;
            root.left = left;
        }

        if (root.right != null) {
            Node right = dfs(root.right);
            right.left = root;
            root.right = right;
            return right;
        }
        return root;


    }*/
}
