package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SerialTree37 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        TreeNode node = root;
        queue.offer(node);
        // 层序遍历存储结点值
        while (!queue.isEmpty()) {
            node = queue.poll();
            // 空结点也要加入stringBuilder
            if (node == null) stringBuilder.append("null");
            else {
                queue.offer(node.left);
                queue.offer(node.right);
                stringBuilder.append(node.val);
            }
            // 每个结点之间用逗号分隔
            stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        // 通过逗号分隔取出所有结点的值（包括null）
        String[] strings = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 字符串中也有空结点，所以每个结点都有两个子节点，循环步长为2
        for (int i = 1; i < strings.length; i = i + 2) {
            TreeNode node = queue.poll();
            if (node == null) continue;

            // node的左右子树
            String leftVal = strings[i];
            String rightVal = strings[i + 1];
            // 空结点不加入队列，因为不存在左右子树
            if (!leftVal.equals("null")) {
                node.left = new TreeNode(Integer.parseInt(leftVal));
                queue.offer(node.left);
            }
            if (!rightVal.equals("null")) {
                node.right = new TreeNode(Integer.parseInt(rightVal));
                queue.offer(node.right);
            }
        }
        return root;
    }
}
