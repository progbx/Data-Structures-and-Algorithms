package com.epam.bsp.binary.tree;

public class TreeNode<E extends Comparable<E>> {

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

    public void setElement(E element) {
        this.element = element;
    }

    public void setLeft(TreeNode<E> left) {
        this.left = left;
    }

    public void setRight(TreeNode<E> right) {
        this.right = right;
    }

    public boolean isBalanced() {
        return Math.abs(height(this.left) - height(this.right)) <= 1
                && (this.left == null || this.left.isBalanced())
                && (this.right == null || this.right.isBalanced());
    }

    private int height(TreeNode<E> node) {
        return node == null ? 0 : 1 + Math.max(height(node.left), height(node.right));
    }

    public boolean isBinarySearchTree() {
        return isBst(this, null, null);
    }

    private boolean isBst(TreeNode<E> node, E min, E max) {
        if (node == null) {
            return true;
        }
        if (min != null && node.element.compareTo(min) <= 0 || max != null && node.element.compareTo(max) >= 0) {
            return false;
        }
        return isBst(node.left, min, node.element) && isBst(node.right, node.element, max);
    }

    public TreeNode<E> searchInBst(E element) {
        if (element.compareTo(this.element) < 0) {
            return this.left == null ? null : this.left.searchInBst(element);
        } else if (element.compareTo(this.element) > 0) {
            return this.right == null ? null : this.right.searchInBst(element);
        } else {
            return this;
        }
    }

    public TreeNode<E> insertInBst(E element) {
        if (element.compareTo(this.element) < 0) {
            if (this.left == null) {
                this.left = new TreeNode<>(element);
            } else {
                this.left.insertInBst(element);
            }
        } else if (element.compareTo(this.element) > 0) {
            if (this.right == null) {
                this.right = new TreeNode<>(element);
            } else {
                this.right.insertInBst(element);
            }
        }
        return this;
    }
}
