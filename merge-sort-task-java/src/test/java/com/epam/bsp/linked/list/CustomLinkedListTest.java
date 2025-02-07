package com.epam.bsp.linked.list;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomLinkedListTest {
    @Test
    public void testMerge() {
        //Example 1
        CustomLinkedList<Integer> listA = new CustomLinkedList<>(List.of(5, 11, 30));
        CustomLinkedList<Integer> listB = new CustomLinkedList<>(List.of(1, 6));
        CustomLinkedList<Integer> result = listA.merge(listB);
        List<Integer> expected = List.of(1, 5, 6, 11, 30);
        assertTrue(result.check(expected));

        //Example 2
        listA = new CustomLinkedList<>(List.of(5, 11, 30));
        listB = new CustomLinkedList<>();
        result = listA.merge(listB);
        expected = List.of(5, 11, 30);
        assertTrue(result.check(expected));

        //Example 3
        listA = new CustomLinkedList<>(List.of(5, 11, 30));
        listB = new CustomLinkedList<>(List.of(5, 11, 30));
        result = listA.merge(listB);
        expected = List.of(5, 5, 11, 11, 30, 30);
        assertTrue(result.check(expected));

        //Example 4
        CustomLinkedList<String> list1 = new CustomLinkedList<>(List.of("a", "bc", "c"));
        CustomLinkedList<String> list2 = new CustomLinkedList<>(List.of("aa", "abc", "bca", "cc"));
        CustomLinkedList<String> merged = list1.merge(list2);
        List<String> sorted = List.of("a", "aa", "abc", "bc", "bca", "c", "cc");
        assertTrue(merged.check(sorted));
    }
}
