package com.epam.bsp.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int getIslandsCount(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numberOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    numberOfIslands++;
                    grid[i][j] = 0;
                    Queue<int[]> neighbours = new LinkedList<>();
                    neighbours.add(new int[]{i, j});

                    while (!neighbours.isEmpty()) {
                        int[] current = neighbours.poll();
                        int row = current[0];
                        int col = current[1];

                        if (row - 1 >= 0 && grid[row-1][col] == 1) {
                            neighbours.add(new int[]{row-1, col});
                            grid[row-1][col] = 0;
                        }

                        if (row + 1 < grid.length && grid[row+1][col] == 1) {
                            neighbours.add(new int[]{row+1, col});
                            grid[row+1][col] = 0;
                        }

                        if (col - 1 >= 0 && grid[row][col-1] == 1) {
                            neighbours.add(new int[]{row, col-1});
                            grid[row][col-1] = 0;
                        }

                        if (col + 1 < grid[0].length && grid[row][col+1] == 1) {
                            neighbours.add(new int[]{row, col+1});
                            grid[row][col+1] = 0;
                        }
                    }
                }
            }
        }
        return numberOfIslands;
    }

    public static int getMinimumKnightMoves(char[][] chessboard) {
        int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
        int n = chessboard.length;
        int m = chessboard[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int startX = 0, startY = 0, endX = 0, endY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (chessboard[i][j] == 'K') {
                    startX = i;
                    startY = j;
                } else if (chessboard[i][j] == 'D') {
                    endX = i;
                    endY = j;
                }
            }
        }
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            int d = point[2];
            if (x == endX && y == endY) {
                return d;
            }
            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY] && chessboard[newX][newY] != 'O') {
                    queue.offer(new int[]{newX, newY, d + 1});
                    visited[newX][newY] = true;
                }
            }
        }
        return -1;
    }
}