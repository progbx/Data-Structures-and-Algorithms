package com.epam.bsp.binary.tree;

import java.util.*;

public class TreeNode<E> {

    private E element;
    private TreeNode<E> left;
    private TreeNode<E> right;

    public TreeNode(E element, TreeNode<E> left, TreeNode<E> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public TreeNode(E element) {
        this(element, null, null);
    }

    public TreeNode(E element, TreeNode<E> left) {
        this(element, left, null);
    }

    public E getElement() {
        return element;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public TreeNode<E> getRight() {
        return right;
    }

    public boolean check(TreeNode<E> treeNode) {
        if (treeNode == null) {
            return false;
        }
        if (this.element.equals(treeNode.element)) {
            boolean leftCheck = (this.left == null) ? (treeNode.left == null) : this.left.check(treeNode.left);
            boolean rightCheck = (this.right == null) ? (treeNode.right == null) : this.right.check(treeNode.right);
            return leftCheck && rightCheck;
        }
        return false;
    }

    public List<E> getInorderTraversal() {
        List<E> result = new ArrayList<>();
        inorder(this, result);
        return result;
    }

    private void inorder(TreeNode<E> node, List<E> result) {
        if (node == null) {
            return;
        }
        inorder(node.left, result);
        result.add(node.element);
        inorder(node.right, result);
    }

    public List<E> getPostorderTraversal() {
        List<E> result = new ArrayList<>();
        postorder(this, result);
        return result;
    }

    private void postorder(TreeNode<E> node, List<E> result) {
        if (node == null) {
            return;
        }
        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.element);
    }

    public List<E> getPreorderTraversal() {
        List<E> result = new ArrayList<>();
        preorder(this, result);
        return result;
    }

    private void preorder(TreeNode<E> node, List<E> result) {
        if (node == null) {
            return;
        }
        result.add(node.element);
        preorder(node.left, result);
        preorder(node.right, result);
    }

    public List<E> getLevelOrderTraversal() {
        List<E> result = new ArrayList<>();
        Queue<TreeNode<E>> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            TreeNode<E> node = queue.poll();
            result.add(node.element);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return result;
    }
}