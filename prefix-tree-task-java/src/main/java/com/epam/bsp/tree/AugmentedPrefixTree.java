package com.epam.bsp.tree;

public class AugmentedPrefixTree extends PrefixTree {
    public AugmentedPrefixTree() {
        super();
    }
    public int countWordsEqualTo(String s) {
        PrefixTreeNode current = rootNode;
        for (char c : s.toCharArray()) {
            if (!current.getChildren().containsKey(c)) {
                return 0;
            }
            current = current.getChildren().get(c);
        }
        return current.getCount();
    }
    public int countWordsStartingWith(String s) {
        return rootNode.countWordsStartingWith(s);
    }
    private int countWords(PrefixTreeNode node) {
        int count = node.isTerminal() ? 1 : 0;
        for (PrefixTreeNode child : node.getChildren().values()) {
            count += countWords(child);
        }
        return count;
    }
}