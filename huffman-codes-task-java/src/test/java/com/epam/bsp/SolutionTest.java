package com.epam.bsp;

import com.epam.bsp.node.TreeNode;
import org.junit.jupiter.api.Test;

import static com.epam.bsp.Solution.*;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    @Test
    public void testCreateHuffmanCoding() {
        //sample tests
        TreeNode huffmanCodingRoot = createHuffmanCoding("cabbaa");
        assertEquals('a', huffmanCodingRoot.getLeftNode().getCh());
        assertEquals('b', huffmanCodingRoot.getRightNode().getLeftNode().getCh());
        assertEquals('c', huffmanCodingRoot.getRightNode().getRightNode().getCh());

        huffmanCodingRoot = createHuffmanCoding("aaaabbbbccdd");
        assertEquals('a', huffmanCodingRoot.getRightNode().getCh());
        assertEquals('b', huffmanCodingRoot.getLeftNode().getLeftNode().getCh());
        assertEquals('c', huffmanCodingRoot.getLeftNode().getRightNode().getLeftNode().getCh());
        assertEquals('d', huffmanCodingRoot.getLeftNode().getRightNode().getRightNode().getCh());

        huffmanCodingRoot = createHuffmanCoding("abcabdedeea");
        assertEquals('a', huffmanCodingRoot.getLeftNode().getLeftNode().getCh());
        assertEquals('d', huffmanCodingRoot.getLeftNode().getRightNode().getLeftNode().getCh());
        assertEquals('c', huffmanCodingRoot.getLeftNode().getRightNode().getRightNode().getCh());
        assertEquals('e', huffmanCodingRoot.getRightNode().getLeftNode().getCh());
        assertEquals('b', huffmanCodingRoot.getRightNode().getRightNode().getCh());

        huffmanCodingRoot = createHuffmanCoding("aaaa");
        assertEquals('a', huffmanCodingRoot.getCh());
    }

    @Test
    public void testEncodeHuffman() {
        //sample tests
        TreeNode huffmanCodingRoot = new TreeNode(
                '*',
                new TreeNode('a', null, null),
                new TreeNode('*',
                        new TreeNode('b', null, null),
                        new TreeNode('c', null, null))
        );
        assertEquals("0100110100", encodeHuffman("abacaba", huffmanCodingRoot));

        huffmanCodingRoot = new TreeNode(
                '*',
                new TreeNode('*',
                        new TreeNode('b', null, null),
                        new TreeNode('*',
                                new TreeNode('c', null, null),
                                new TreeNode('d', null, null))),
                new TreeNode('a', null, null)
        );
        assertEquals("10010101001", encodeHuffman("abacaba", huffmanCodingRoot));

        huffmanCodingRoot = new TreeNode(
                '*',
                new TreeNode('*',
                        new TreeNode('a', null, null),
                        new TreeNode('*',
                                new TreeNode('d', null, null),
                                new TreeNode('c', null, null))),
                new TreeNode('*',
                        new TreeNode('e', null, null),
                        new TreeNode('b', null, null))
        );
        assertEquals("001100011001100", encodeHuffman("abacaba", huffmanCodingRoot));

        huffmanCodingRoot = new TreeNode('a', null, null);
        assertEquals("0000", encodeHuffman("aaaa", huffmanCodingRoot));
    }


    @Test
    public void testDecodeHuffman() {
        //sample tests
        TreeNode huffmanCodingRoot = new TreeNode(
                '*',
                new TreeNode('a', null, null),
                new TreeNode('*',
                        new TreeNode('b', null, null),
                        new TreeNode('c', null, null))
        );
        assertEquals("abacaba", decodeHuffman("0100110100", huffmanCodingRoot));

        huffmanCodingRoot = new TreeNode(
                '*',
                new TreeNode('*',
                        new TreeNode('b', null, null),
                        new TreeNode('*',
                                new TreeNode('c', null, null),
                                new TreeNode('d', null, null))),
                new TreeNode('a', null, null)
        );
        assertEquals("abacaba", decodeHuffman("10010101001", huffmanCodingRoot));

        huffmanCodingRoot = new TreeNode(
                '*',
                new TreeNode('*',
                        new TreeNode('a', null, null),
                        new TreeNode('*',
                                new TreeNode('d', null, null),
                                new TreeNode('c', null, null))),
                new TreeNode('*',
                        new TreeNode('e', null, null),
                        new TreeNode('b', null, null))
        );
        assertEquals("abacaba", decodeHuffman("001100011001100", huffmanCodingRoot));

        huffmanCodingRoot = new TreeNode('a', null, null);
        assertEquals("aaaa", decodeHuffman("0000", huffmanCodingRoot));
    }

}