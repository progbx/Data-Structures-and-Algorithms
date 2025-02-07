package com.epam.bsp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class SolutionTest {

    @Test
    public void testHeapSort() {
        //Example 1
        int[] data = {6, 4, 2, 1, 6, 3};
        List<Integer> dataList = Arrays.stream(data).boxed().toList();
        List<Integer> h = Solution.minHeapify(dataList);
        assertEquals(dataList.size(), h.size());
        assertEquals(new HashSet<Integer>(h), new HashSet<Integer>(dataList));
        checkHeap(h);
        assertArrayEquals(
                new int[] {1, 2, 3, 4, 6, 6},
                Solution.heapSort(data)
        );

        //Example 2
        data = new  int[]{1000, 100, 1, 10};
        dataList = Arrays.stream(data).boxed().toList();
        h = Solution.minHeapify(dataList);
        Set<List<Integer>> versions = Set.of(
                List.of(1, 10, 100, 1000),
                List.of(1, 100, 10, 1000),
                List.of(1, 10, 1000, 100)
        );
        assertTrue(versions.contains(h));
        assertArrayEquals(
                new int[] {1, 10, 100, 1000},
                Solution.heapSort(data)
        );
    }


    private void checkHeap(List<Integer> h) {
        for (int i = 0; i < h.size(); i++) {
            final int iMul2Add1 = (i << 1) + 1;
            if(iMul2Add1 < h.size()) {
                assertTrue(h.get(i) <= h.get(iMul2Add1));
            }
            if(iMul2Add1 + 1 < h.size()) {
                assertTrue(h.get(i) <= h.get(iMul2Add1 + 1));
            }
        }
    }

}