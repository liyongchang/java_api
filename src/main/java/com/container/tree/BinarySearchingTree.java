package com.container.tree;

public class BinarySearchingTree {
    private BinaryTreeNode root;

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    public BinaryTreeNode search(int data) {
        return searchData(root, data);
    }

    /**
     * 递归二叉查找树
     * @param node
     * @param data
     * @return
     */
    private BinaryTreeNode searchData(BinaryTreeNode node, int data) {
        if (node == null) {
            return null;
        } else if (node.getData() == data) {
            return node;
        } else if (data > node.getData()) {
            return searchData(node.getRightChild(), data);
        } else {
            return searchData(node.getLeftChild(), data);
        }
    }




}
