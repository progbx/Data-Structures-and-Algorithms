# Graph representation

## Purpose

The coding exercises are designed to test your knowledge of the following concepts:

* Representations of graphs in memory
* An adjacency matrix as a data structure for representing graphs in memory
* An adjacency dictionary as a data structure for representing graphs in memory

## Overview

The coding exercises cover the following practical problems:
* Implementing the `Adjacency matrix` data structure for undirected graphs
* Implementing the `Adjacency dictionary` data structure for undirected graphs

## Coding exercises

### Intro: Interface for representing undirected graphs

The coding exercises will cover some possible options for implementing the following interface:

```java
public interface UndirectedGraphRepresentation {

    /**
     * Adds a new edge to the graph.
     *
     * @param vertexA the first vertex.
     * @param vertexB the second vertex.
     */
    void addEdge(int vertexA, int vertexB);

    /**
     * Returns a binary (0/1) list for the given vertex that indicates vertices adjacent to it.
     * <p>
     * Positions of 1-s in the result list correspond to vertices that are adjacent to the given vertex.
     * E.g. V = {0,1,2), E = {{0,1}, {1,2}} the following list should be returned for the vertex 0:
     * [0, 1, 0].
     *
     * @param vertex the vertex of interest.
     * @return the binary vector where 1-s indicate that the corresponding
     * vertices are adjacent to the given vertex.
     */
    int[] getAdjacencyIndicators(int vertex);

    /**
     * Returns the number of adjacent vertices to the given vertex.
     *
     * @param vertex the vertex of interest.
     * @return the number of vertices in the graph that are adjacent to the given vertex.
     */
    int getNumberOfAdjacentVertices(int vertex);

    /**
     * Returns True if the given edge exists in the graph (between two given vertices).
     *
     * @param vertexA the first vertex.
     * @param vertexB the second vertex.
     * @return whether the given edge exists in the graph.
     */
    boolean edgeExists(int vertexA, int vertexB);
}
```

As you can see, multiple details might need clarification:
* Constructors of classes which will implement the interface above will expect the number of vertices in the graph (`N`). 
* Assume that vertices are enumerated from `0` to `N-1`.
* The `addEdge` method helps add of new edges to the graph.
* The `getNumberOfAdjacentVertices` and `getAdjacencyIndicators` methods are used to get information about vertices adjacent to a vertex of interest.
* The `edgeExists` method simply checks whether certain edges of interest are present in the graph.

    ### Exercise 1: The adjacency matrix for undirected graphs

The first option for implementing the interface above is 
to store the required information in adjacency matrix, 
which will require `O(N^2)` memory for graphs with `N` vertices. 
Also, we can estimate time complexities for the methods that should be implemented:
* The constructor is expected to have `O(N^2)` time complexity, because we need to create the initial (empty) adjacency matrix.
* The `addEdge` is expected to have `O(1)` time complexity.
* The `getAdjacencyIndicators` is expected to have `O(N)` time complexity.
* The `getNumberOfAdjacentVertices` is expected to have `O(N)` time complexity.
* The `edgeExists` is expected to have `O(1)` time complexity.

Your task is to implement the following class for representing undirected graphs in memory:

```java
public class GraphAdjacencyMatrix implements UndirectedGraphRepresentation {
    private int[][] adjacencyMatrix;

    public GraphAdjacencyMatrix(int numberOfVertices) {
        // put your code here
    }

    public void addEdge(int vertexA, int vertexB) {
        // put your code here
    }

    public int[] getAdjacencyIndicators(int vertex) {
        // put your code here
        return new int[0];
    }

    public int getNumberOfAdjacentVertices(int vertex) {
        // put your code here
        return 0;
    }

    public boolean edgeExists(int vertexA, int vertexB) {
        // put your code here
        return false;
    }
}
```

Please check the unit tests to gain an understanding of how to use the class *in the field*.

<br>

Please use the template `GraphAdjacencyMatrix` for the implementation.


### Exercise 2: The adjacency dictionary for undirected graphs

The second option for implementing the interface above is 
to store the required information in some kind of hash table, 
which will require `O(N+M)` memory for graphs with `N` vertices and `M` edges. 
Also, we can estimate time complexities for the methods that should be implemented:
* The constructor is expected to have up to `O(N)` time complexity, it will depend on the initialization strategy of your choice.
* The `addEdge` is expected to have `O(1)` time complexity.
* The `getAdjacencyIndicators` is expected to have `O(N)` time complexity.
* The `getNumberOfAdjacentVertices` is expected to have `O(1)` time complexity.
* The `edgeExists` is expected to have `O(1)` time complexity.

Here we assume the both `HashMap` and `HashSet` have `O(1)` time complexity for insert/get operations.

Your task is to implement the following class for representing undirected graphs in memory:

```java
public class GraphAdjacencyDictionary implements UndirectedGraphRepresentation {
    private Map<Integer, Set<Integer>> adjacencyDictionary;

    public GraphAdjacencyDictionary(int numberOfVertices) {
        // put your code here
    }

    public void addEdge(int vertexA, int vertexB) {
        // put your code here
    }

    public int[] getAdjacencyIndicators(int vertex) {
        // put your code here
        return new int[0];
    }

    public int getNumberOfAdjacentVertices(int vertex) {
        // put your code here
        return 0;
    }

    public boolean edgeExists(int vertexA, int vertexB) {
        // put your code here
        return false;
    }
}
```

Please check the unit tests to gain an understanding of how to use the class *in the field*.

<br>

Please use the template `GraphAdjacencyDictionary` for the implementation.
