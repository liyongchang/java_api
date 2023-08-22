package com.leetcode;

public class No28SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isOk(root.left, root.right);
    }

    private boolean isOk(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;
        if (A == null || B == null) return false;
        if (A.val != B.val) return false;
        return isOk(A.left, B.right) && isOk(A.right, B.left);
    }

}
