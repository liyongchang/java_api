package com.container.tree;


public class BinaryTree {
    private BinaryTreeNode root;

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    public void clear(BinaryTreeNode node) {
        if (node != null) {
            clear(node.getLeftChild());
            clear(node.getRightChild());
            node = null;
        }
    }

    public void clear() {
        clear(root);
    }

    public boolean idEmpty() {
        return root == null;
    }

    public int height() {
        return height(root);
    }

    public int size() {
        return size(root);
    }

    public BinaryTreeNode getParent(BinaryTreeNode node) {
        return (root == null || root == node) ? null : getParent(root, node);
    }

    public BinaryTreeNode getLeftTree(BinaryTreeNode node) {
        return node.getLeftChild();
    }

    public BinaryTreeNode getRightTree(BinaryTreeNode node) {
        return node.getRightChild();
    }

    public void insertLeft(BinaryTreeNode parent, BinaryTreeNode node) {
        parent.setLeftChild(node);
    }

    public void insertRight(BinaryTreeNode parent, BinaryTreeNode node) {
        parent.setLeftChild(node);
    }


    /**
     * 查找节点的父节点
     *
     * @param treeRoot 子树
     * @param node     节点
     * @return
     */
    private BinaryTreeNode getParent(BinaryTreeNode treeRoot, BinaryTreeNode node) {
        if (treeRoot == null) {
            return null;
        }
        if (treeRoot.getLeftChild() == node || treeRoot.getRightChild() == node) {
            return treeRoot;
        }
        BinaryTreeNode parent = null;
        if ((parent = getParent(treeRoot.getLeftChild(), node)) != null) {
            return parent;
        }
        return getParent(treeRoot.getRightChild(), node);
    }

    /**
     * 二叉树的节点树
     *
     * @param root
     * @return
     */
    private int size(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        return size(root.getLeftChild()) + size(root.getRightChild()) + 1;
    }

    /**
     * 二叉树的高度
     *
     * @param node
     * @return
     */
    private int height(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = height(node.getLeftChild());
        int r = height(node.getRightChild());
        return l < r ? r + 1 : l + 1;
    }

    public void preOrder(BinaryTreeNode node) {
        if (node != null) {
            visit(node);
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }

    public void visit(BinaryTreeNode node) {
        System.out.printf(node.getData() + "");
    }


}
