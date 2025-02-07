package com.epam.bsp.tree;

public class PrefixTree {
    public PrefixTreeNode rootNode;
    public PrefixTree() {
        this.rootNode = new PrefixTreeNode(false);
    }
    public void insert(String s) {
        PrefixTreeNode current = rootNode;
        for (char c : s.toCharArray()) {
            current.getChildren().putIfAbsent(c, new PrefixTreeNode(false));
            current = current.getChildren().get(c);
        }
        current.setTerminal(true);
    }
    public boolean search(String s) {
        PrefixTreeNode current = rootNode;
        for (char c : s.toCharArray()) {
            if (!current.getChildren().containsKey(c)) {
                return false;
            }
            current = current.getChildren().get(c);
        }
        return current.isTerminal();
    }
    public boolean startsWith(String s) {
        PrefixTreeNode current = rootNode;
        for (char c : s.toCharArray()) {
            if (!current.getChildren().containsKey(c)) {
                return false;
            }
            current = current.getChildren().get(c);
        }
        return true;
    }
}