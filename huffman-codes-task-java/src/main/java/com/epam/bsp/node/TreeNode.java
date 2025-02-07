package com.epam.bsp.node;

public class TreeNode {
    private char ch;
    private TreeNode leftNode;
    private TreeNode rightNode;
    public TreeNode(char ch, TreeNode leftNode, TreeNode rightNode) {
        this.ch = ch;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
    public char getCh() {
        return ch;
    }
    public TreeNode getLeftNode() {
        return leftNode;
    }
    public TreeNode getRightNode() {
        return rightNode;
    }
}