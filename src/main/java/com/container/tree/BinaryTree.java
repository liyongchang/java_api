package com.container.tree;


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    /**
     * 层序遍历
     * 1.用队列存储元素
     * 2.add 入队，pool 出队
     * 3.收敛条件队列有值
     *
     * @param node
     */
    public void levelOrder(BinaryTreeNode node) {
        Queue<BinaryTreeNode> binaryTreeNodes = new LinkedList<>();
        binaryTreeNodes.add(node);
        while (!binaryTreeNodes.isEmpty()) {
            BinaryTreeNode binaryTreeNode = binaryTreeNodes.poll();
            visit(binaryTreeNode);
            if (null != binaryTreeNode.getLeftChild()) {
                binaryTreeNodes.add(binaryTreeNode.getLeftChild());
            }
            if (null != binaryTreeNode.getRightChild()) {
                binaryTreeNodes.add(binaryTreeNode.getRightChild());
            }
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //容器3 放返回值
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        //容器1，放节点
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            //容器2 中间层
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    //核心节点 往尾部放
                    levelList.offerLast(curNode.val);
                } else {
                    //核心节点 往头部放
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || inorder.length == 0) {
            return null;
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preorderStart, int preorderEnd,
                           int[] inorder, int inorderStart, int inorderEnd) {
        if (preorderStart > preorderEnd || inorderStart > inorderEnd) {
            return null;
        }
        int val = preorder[preorderStart];
        TreeNode root = new TreeNode(val);
        int index = 0;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }
        int leftSize = index - inorderStart;
        root.left = build(preorder, preorderStart + 1, preorderStart + leftSize,
                inorder, inorderStart, index - 1);
        root.right = build(preorder, preorderStart + leftSize + 1, preorderEnd,
                inorder, index + 1, inorderEnd);
        return root;
    }

}
