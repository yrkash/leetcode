package ru.yrkash.task200;


import ru.yrkash.task230.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    // Define grid and its dimensions
    private char[][] grid;
    private int numRows;
    private int numCols;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        numRows = grid.length;
        numCols = grid[0].length;

        int numIslands = 0;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    depthFirstSearch(i, j);
                }
            }
        }

        return numIslands;
    }

    // Helper method to perform DFS to mark all cells of an island as visited
    private void depthFirstSearch(int row, int col) {
        // Mark the current cell as visited by setting it to '0'
        grid[row][col] = '0';

        // Array to facilitate the exploration of adjacent directions (up, right, down, left)
        int[] directions = {-1, 0, 1, 0, -1};

        // Explore all 4 adjacent directions
        for (int k = 0; k < 4; ++k) {
            int newRow = row + directions[k];
            int newCol = col + directions[k + 1];
            // Check boundaries and if the adjacent cell is part of an island
            if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols && grid[newRow][newCol] == '1') {
                // Continue DFS exploration for the adjacent cell
                depthFirstSearch(newRow, newCol);
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid  = {
        {'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}
    };

        System.out.println(solution.numIslands(grid));
    }
}
