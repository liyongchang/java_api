package com.leetcode;

public class No27MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;//边界测试很重要，且可以作为后面的截止条件
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        root.left = mirrorTree(root.left);
        root.right = mirrorTree(root.right);
        return root;
    }
}
