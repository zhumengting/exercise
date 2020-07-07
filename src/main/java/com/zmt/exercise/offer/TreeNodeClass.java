package com.zmt.exercise.offer;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class TreeNodeClass {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("([+-]?(([0-9]+([.][0-9]+)?)|(0.[0-9]+)))+(e[-]?[0-9]*)");

        boolean isMatch = pattern.matcher("+0.7").matches();
        System.out.println(isMatch);
    }

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return dfs(A, B, true);
    }

    public static boolean dfs(TreeNode A, TreeNode B, boolean isRoot) {
        if (isRoot) {
            if (A == null) {
                return false;
            }
            if (B.val == A.val) {
                return dfs(A.left, B.left, false) && dfs(A.right, B.right, false);
            } else {
                return dfs(A.left, B, true) || dfs(A.right, B, true);
            }
        } else {
            if (B == null) {
                return true;
            }
            if (A == null) {
                return false;
            }
            if (B.val == A.val) {
                return dfs(A.left, B.left, false) && dfs(A.right, B.right, false);
            } else {
                return false;
            }
        }
    }

    public static ArrayList<Integer> preorder(TreeNode t) {
        ArrayList<Integer> list = new ArrayList<>();
        if (t == null) {
            return list;
        }
        list.addAll(preorder(t.left));
        list.addAll(preorder(t.right));
        list.add(t.val);
        return list;

    }

    public TreeNode mirrorTree(TreeNode root) {
        TreeNode t = new TreeNode(root.val);
        t.left = mirrorTree(root.right);
        t.right = mirrorTree(root.left);
        return t;
    }


/*    public double minimalExecTime(TreeNode root) {
        double time = 0.0;
        if(root == null){
            return time;
        }
        double left = minimalExecTime(root.left);
        double right = minimalExecTime(root.right);
        double minus = judge(root.left,root.right,left,right);
        return left+right-minus+root.val;
    }
    public double judge(TreeNode left,TreeNode right,double lt,double rt){
        if(lt == 0 || rt == 0 || lt == rt || (lt>rt && left.val>right.val) || (lt<rt && left.val<right.val)){
            return 0;
        }
        return -Math.abs(left.val-right.val)-Math.min(left.val,right.val);
    }*/

}
