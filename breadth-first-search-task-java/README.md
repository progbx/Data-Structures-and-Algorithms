# Breadth-first search

## Purpose

The following coding exercises are designed to test your knowledge of the following concepts:

* The Breadth-first search approach to graph traversal

## Overview

The coding exercises cover the following practical problems:
* Calculating the number of connectivity components in a given undirected graph
* Checking whether a given undirected graph has any cycles
* Finding all the distances from a given graph vertex to the other vertices

## Coding exercises

### Exercise 1: Calculate number of connectivity components in an undirected graph

Given the number of vertices `n` and graph edges (adjacency dictionary) `edges` for an undirected graph, implement a static method to calculate the number of connectivity components. Vertices are enumerated from `0` to `n-1`.

```java
/**
 * Returns the number of connectivity components in an undirected graph.
 *
 * E.g. there is a graph with 6 vertices from 0 to 5 and edges {{0,1}, {1,5}, {5,0}, {3,4}},
 *   there are 3 connectivity components: {0, 5, 1}, {2}, {3,4}.
 * Edges above will have the following 'adjacency dictionary' look: 
 *   {0: {1,5}, 1: {0,5}, 3: {4}, 4: {3}, 5: {0,1}}.
 *
 * @param n the number of vertices in the graph, vertices are enumerated from 0 to n-1.
 * @param edges the adjacency dictionary which stores a set of adjacent vertices for each vertex.
 * @return the number of connectivity components in the given undirected graph.
 */
public static int findNumberOfComponents(int n, Map<Integer, Set<Integer>> edges) {
        //put your code here
        return 0;
}
```

**Example 1:**
```mermaid
graph TD;
    A((0)) ---- B((1));
    A ---- C((2));
    B --- C;
    E((4));
    D((3));
```

Expected result: 3.

**Example 2:**
```mermaid
graph TD;
    A((0));
    B((1));
    C((2));
    E((4));
    D((3));
```

Expected result: 5.

**Example 3:**
```mermaid
graph TD;
    A((0)) ---- B((1));
    A ---- C((2));
    B --- C;
    E((4));
    D((3));
    D --- B;
    E --- C;
```

Expected result: 1.

<br>

Please use the template `Solution.findNumberOfComponents` for the implementation.


### Exercise 2: Checking whether a given undirected graph has any cycles

Given the number of vertices `n` and graph edges (adjacency dictionary) `edges` for an undirected graph, return True if graph contains a cycle and False if it doesn't. Vertices are enumerated from `0` to `n-1`.

```java
/**
 * Returns True if there is at least one cycle in the undirected graph.
 *
 * E.g. there is a graph with 6 vertices from 0 to 5 and edges {{0,1}, {1,5}, {5,0}, {3,4}},
 *   the expected result is True because there is a cycle 0 - 1 - 5 - 0.
 *
 * @param n the number of vertices in the graph, vertices are enumerated from 0 to n-1.
 * @param edges the adjacency dictionary which stores a set of adjacent vertices for each vertex.
 * @return True if there is a cycle in the undirected graph, otherwise False
 */
public static boolean checkCycleExistence(int n,Map<Integer, Set<Integer>> edges) {
        //put your code here
        return false;
}
```

**Example 1:**
```mermaid
graph TD;
    A((0)) ---- B((1));
    A ---- C((2));
    B --- C;
    E((4));
    D((3));
```

Expected result: True.

**Example 2:**
```mermaid
graph TD;
    A((0));
    B((1));
    C((2));
    E((4));
    D((3));
```

Expected result: False.

**Example 3:**
```mermaid
graph TD;
    A((0)) ---- B((1));
    B --- C((2));
    D((3)) --- E((4));
```

Expected result: False.

<br>

Please use the template `Solution.checkCycleExistence` for the implementation.

### Exercise 3: Find all the distances from the given vertex to the other vertices

Given the number of vertices `n`, graph edges (adjacency dictionary) `edges` and an initial vertex `vertex` for an undirected graph, return a distance list  where index `i` indicates the distance between vertices `vertex` and `i`. Vertices are enumerated from `0` to `n-1`. If there is no path from `vertex` to any vertex `i`, set the distance to `-1` at index `i`.


```java
/**
 * Returns a list with the minimum distances from the vertex to all vertices, including itself.
 *
 * NOTE: If there is no path, please set the distance to -1.
 *
 * E.g. you have graph with 4 vertices from 0 to 3 and edges {{0,1}, {1,2}). 
 * Initial vertex is 2, and the expected result is [2, 1, 0, -1]. 
 * - 2 at the first position (index 0) means that two edges
 *     are needed to get from vertex '2' to vertex '0': 2 -> 1 -> 0. 
 * - At the 2nd position (index 1), there is 1 because the vertices '1' and '2' are adjacent.
 * - 0 is placed on the 3rd place (index 2) because it is the starting point and 
 *     the list ends with -1 because there is no path between vertices '2' and '3'.
 *
 * @param n the number of vertices in the graph, vertices are enumerated from 0 to n-1.
 * @param edges the adjacency dictionary which stores a set of adjacent vertices for each vertex.
 * @param vertex the initial vertex
 * @return the result distance list which reflects the distances between initial vertex and 
 *   all other vertices, the number at each index I shows the distance from starting vertex to vertex I.
 */
public static int[] getDistancesFromVertex(int n, Map<Integer, Set<Integer>> edges, int vertex) {
        //put your code here
        return new int[0];
}
```

**Example 1:**
```mermaid
graph TD;
    A((0)) ---- B((1));
    A ---- C((2));
    B --- C;
    E((4));
    D((3));
```
`vertex` = 2

Expected result: [1, 1, 0, -1, -1].

**Example 2:**
```mermaid
graph TD;
    A((0));
    B((1));
    C((2));
    E((4));
    D((3));
```
`vertex` = 4

Expected result: [-1, -1, -1, -1, 0].

**Example 3:**
```mermaid
graph TD;
    A((0)) ---- B((1));
    B --- C((2));
    D((3)) --- E((4));
    B --- D;
```
`vertex` = 0

Expected result: [0, 1, 2, 2, 3].

<br>

Please use the template `Solution.getDistancesFromVertex` for the implementation.
