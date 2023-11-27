package ru.yrkash.task36;


import java.util.*;

public class Solution {


    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i) || !isValidColumn(board, i) || !isValidSubgrid(board, i)) {
                return false;
            }
        }
        return true;
    }
    private boolean isValidRow(char[][] board, int row) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (board[row][i] != '.' && !set.add(board[row][i])) {
                return false;
            }
        }
        return true;
    }
    private boolean isValidColumn(char[][] board, int col) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && !set.add(board[i][col])) {
                return false;
            }
        }
        return true;
    }
    private boolean isValidSubgrid(char[][] board, int subgrid) {
        Set<Character> set = new HashSet<>();
        int rowOffset = (subgrid / 3) * 3;
        int colOffset = (subgrid % 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char value = board[rowOffset + i][colOffset + j];
                if (value != '.' && !set.add(value)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] sudoku =
                {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(solution.isValidSudoku(sudoku));
    }
}
