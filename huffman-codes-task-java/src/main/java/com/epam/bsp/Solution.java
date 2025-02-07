package com.epam.bsp;

import com.epam.bsp.node.TreeNode;
import java.util.*;

public class Solution {
    public static TreeNode createHuffmanCoding(String text) {
        // Step 1: Calculate character frequencies
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<TreeNode> queue = new PriorityQueue<>(
                Comparator.comparingInt(a -> frequencyMap.getOrDefault(a.getCh(), 0)));
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            queue.offer(new TreeNode(entry.getKey(), null, null));
        }
        while (queue.size() > 1) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            TreeNode combinedNode = new TreeNode('\0', left, right);
            queue.offer(combinedNode);
        }
        return queue.poll();
    }

    public static String encodeHuffman(String text, TreeNode huffmanCodingRoot) {
        if (huffmanCodingRoot.getLeftNode() == null && huffmanCodingRoot.getRightNode() == null) {
            return "0".repeat(text.length());
        }
        Map<Character, String> huffmanMap = new HashMap<>();
        buildHuffmanMap(huffmanCodingRoot, "", huffmanMap);
        StringBuilder encodedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            encodedText.append(huffmanMap.get(c));
        }
        return encodedText.toString();
    }
    private static void buildHuffmanMap(TreeNode node, String code, Map<Character, String> huffmanMap) {
        if (node == null)
            return;
        if (node.getLeftNode() == null && node.getRightNode() == null) {
            huffmanMap.put(node.getCh(), code);
        }
        buildHuffmanMap(node.getLeftNode(), code + "0", huffmanMap);
        buildHuffmanMap(node.getRightNode(), code + "1", huffmanMap);
    }
    public static String decodeHuffman(String text, TreeNode huffmanCodingRoot) {
        if (huffmanCodingRoot.getLeftNode() == null && huffmanCodingRoot.getRightNode() == null) {
            char ch = huffmanCodingRoot.getCh();
            return String.valueOf(ch).repeat(text.length());
        }
        StringBuilder decodedText = new StringBuilder();
        TreeNode currentNode = huffmanCodingRoot;
        for (char bit : text.toCharArray()) {
            currentNode = (bit == '0') ? currentNode.getLeftNode() : currentNode.getRightNode();
            if (currentNode.getLeftNode() == null && currentNode.getRightNode() == null) {
                decodedText.append(currentNode.getCh());
                currentNode = huffmanCodingRoot;
            }
        }
        return decodedText.toString();
    }
}