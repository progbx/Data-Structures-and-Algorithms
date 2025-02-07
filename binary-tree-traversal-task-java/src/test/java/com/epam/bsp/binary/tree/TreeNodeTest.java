package com.epam.bsp.binary.tree;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeNodeTest {

    private static TreeNode<Integer> tree0, tree1, tree2;

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
    }

    @Test
    public void testCheckSample() {
        assertFalse(tree0.check(null));
        assertTrue(tree0.check(
                new TreeNode<>(107))
        );
        assertTrue(tree1.check(
                new TreeNode<>(
                        107, new TreeNode<>(109), new TreeNode<>(110)
                )
        ));
        assertFalse(tree1.check(tree2));

        TreeNode<String> stringTreeNode = new TreeNode<>("01");
        assertTrue(stringTreeNode.check(
                new TreeNode<>("01")
        ));

        TreeNode<String> stringTreeNode2 = new TreeNode<>("012");
        assertFalse(stringTreeNode2.check(
                new TreeNode<>("12")
        ));
    }

    @Test
    public void testGetInorderTraversalSample() {
        assertEquals(List.of(107), tree0.getInorderTraversal());
        assertEquals(List.of(109, 107, 110), tree1.getInorderTraversal());
        assertEquals(List.of(1234, 109, 107, 110), tree2.getInorderTraversal());
    }

    @Test
    public void testGetPostorderTraversalSample() {
        assertEquals(List.of(107), tree0.getPostorderTraversal());
        assertEquals(List.of(109, 110, 107), tree1.getPostorderTraversal());
        assertEquals(List.of(1234, 109, 110, 107), tree2.getPostorderTraversal());
    }

    @Test
    public void testGetPreorderTraversalSample() {
        assertEquals(List.of(107), tree0.getPreorderTraversal());
        assertEquals(List.of(107, 109, 110), tree1.getPreorderTraversal());
        assertEquals(List.of(107, 109, 1234, 110), tree2.getPreorderTraversal());
    }

    @Test
    public void testLevelOrderTraversalSample() {
        assertEquals(List.of(107), tree0.getLevelOrderTraversal());
        assertEquals(List.of(107, 109, 110), tree1.getLevelOrderTraversal());
        assertEquals(List.of(107, 109, 110, 1234), tree2.getLevelOrderTraversal());
    }
}
