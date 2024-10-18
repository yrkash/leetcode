package ru.yrkash.task130;


public class Solution {

    // Define grid and its dimensions
    private char[][] board;
    private int rows;
    private int cols;

    public void solve(char[][] board) {
        rows = board.length; // Set the number of rows
        cols = board[0].length; // Set the number of columns
        this.board = board; // Initialize the board member variable

        // Explore all 'O' on the borders, any 'O' connected to them should not be flipped
        // hence temporarily mark them with '.'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Condition to check if it's on the border and if it's an 'O'
                if ((i == 0 || i == rows - 1 || j == 0 || j == cols - 1) && board[i][j] == 'O') {
                    depthFirstSearch(i, j); // Call DFS to mark the connected 'O's
                }
            }
        }

        // Flip all remaining 'O' to 'X' and back all '.' to 'O'.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If it was marked '.', it's safe to flip it back to 'O'
                if (board[i][j] == '.') {
                    board[i][j] = 'O';
                }
                // If it's still an 'O', it should be flipped to 'X' as it is not connected to a border
                else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    // Depth-first search function to find all the 'O's connected to a border 'O'
    private void depthFirstSearch(int row, int col) {
        board[row][col] = '.'; // Mark the cell as visited by replacing 'O' with '.'
        int[] directions = {-1, 0, 1, 0, -1}; // Directions to move in the matrix
        for (int k = 0; k < 4; k++) { // Loop through possible directions (up, right, down, left)
            int nextRow = row + directions[k];
            int nextCol = col + directions[k + 1];
            // Check bounds and if the next cell is 'O', continue DFS
            if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && board[nextRow][nextCol] == 'O') {
                depthFirstSearch(nextRow, nextCol); // Recursive call for connected 'O's
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board  = {
        {'X','X','X','X','X'},
        {'X','X','O','O','O'},
        {'X','X','X','O','X'},
        {'O','O','O','X','X'}
        };

        solution.solve(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
