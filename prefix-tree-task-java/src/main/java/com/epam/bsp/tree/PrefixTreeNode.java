package com.epam.bsp.tree;

import java.util.HashMap;
import java.util.Map;

public class PrefixTreeNode {
    private Map<Character, PrefixTreeNode> children;
    private boolean terminal;
    private int count;
    public PrefixTreeNode(boolean terminal) {
        this.children = new HashMap<>();
        this.terminal = terminal;
    }
    public Map<Character, PrefixTreeNode> getChildren() {
        return children;
    }
    public boolean isTerminal() {
        return terminal;
    }
    public void setTerminal(boolean terminal) {
        count++;
        this.terminal = terminal;
    }
    public int getCount() {
        return count;
    }
    public int countWordsStartingWith(String s) {
        return countWordsStartingWith(s.toCharArray(), 0);
    }
    private int countWordsStartingWith(char[] chars, int idx) {
        if (chars.length <= idx) {
            var countWords = count;
            for (var val : children.values())
                countWords += val.countWordsStartingWith(chars, idx + 1);
            return countWords;
        }
        return children.getOrDefault(chars[idx], new PrefixTreeNode(false)).countWordsStartingWith(chars, idx + 1);
    }
}