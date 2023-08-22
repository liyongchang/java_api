package com.leetcode;

public class No26SubTree {
    private boolean isSubStree(TreeNode root1, TreeNode root2) {//从当前根节点直接比较
        // 若B走完了,说明查找完毕,B为A的子结构
        if (root2 == null) return true;
        // 若B不为空并且A为空或者A与B的值不相等,直接可以判断B不是A的子结构
        if (root1 == null) return false;
        if (root1.val != root2.val) return false;
        // 当A与B当前节点值相等,若要判断B为A的子结构
        // 还需要判断B的左子树是否为A左子树的子结构 && B的右子树是否为A右子树的子结构
        // 若两者都满足就说明B是A的子结构,并且该子结构以A根节点为起点
        return isSubStree(root1.left, root2.left) && isSubStree(root1.right, root2.right);
    }

    /**
     * 判断B是否为A的子结构
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        // B为A的子结构有3种情况,满足任意一种即可:
        // 1.B的子结构起点为A的根节点,此时结果为recur(A,B)
        // 2.B的子结构起点隐藏在A的左子树中,而不是直接为A的根节点,此时结果为isSubStructure(A.left, B)
        // 3.B的子结构起点隐藏在A的右子树中,此时结果为isSubStructure(A.right, B)
        return isSubStree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
