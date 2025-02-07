package com.epam.bsp.binary.tree;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TreeNodeTest {

    private static TreeNode<Integer> tree0, tree1, tree2, tree3;

    @BeforeAll
    public static void init() {
        tree0 = new TreeNode<>(107);
        tree1 = new TreeNode<>(
                107, new TreeNode<>(109), new TreeNode<>(110)
        );
        tree2 = new TreeNode<>(
                107,
                new TreeNode<>(109, new TreeNode<>(1234), null),
                new TreeNode<>(110)
        );
        tree3 = new TreeNode<>(
                110,
                new TreeNode<>(
                        108,
                        new TreeNode<>(
                                106,
                                new TreeNode<>(105)
                        ),
                        new TreeNode<>(109)
                ),
                new TreeNode<>(111)
        );
    }

    @Test
    public void testIsBalanced() {
        assertTrue(tree0.isBalanced());
        assertTrue(tree1.isBalanced());
        assertTrue(tree2.isBalanced());
        assertFalse(tree3.isBalanced());
    }

    @Test
    public void testSearchInBst() {
        TreeNode<Integer> node = tree3.searchInBst(106);
        assertEquals(106, node.getElement());
        assertEquals(105, node.getLeft().getElement());
        assertNull(node.getRight());

        node = tree3.searchInBst(111);
        assertEquals(111, node.getElement());
        assertNull(node.getLeft());
        assertNull(node.getRight());

        node = tree3.searchInBst(13341);
        assertNull(node);
    }

    @Test
    public void testInsertInBst() {
        TreeNode<Integer> resultNode = tree0.insertInBst(110);
        assertEquals(107, resultNode.getElement());
        assertNull(resultNode.getLeft());
        assertEquals(110, resultNode.getRight().getElement());


        TreeNode<String> inputTree = new TreeNode<>("b", new TreeNode<>("a"));
        TreeNode<String> resultTreeRoot = inputTree.insertInBst("c");
        assertEquals("b", resultTreeRoot.getElement());
        assertEquals("a", resultTreeRoot.getLeft().getElement());
        assertEquals("c", resultTreeRoot.getRight().getElement());
    }

    @Test
    public void testIsBinarySearchTree() {
        assertTrue(tree0.isBinarySearchTree());
        assertFalse(tree1.isBinarySearchTree());
        assertFalse(tree2.isBinarySearchTree());
        assertTrue(tree3.isBinarySearchTree());
    }

}
