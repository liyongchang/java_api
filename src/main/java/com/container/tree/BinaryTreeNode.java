package com.container.tree;

import lombok.Data;

@Data
public class BinaryTreeNode {
    private int data;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;
}
