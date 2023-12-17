package ru.yrkash.task289;

import java.util.Arrays;

public class Solution {

    public void gameOfLife(int[][] board) {
        int[][] boardCopy = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boardCopy[i][j] = board [i][j];
                if (sumAdjacentElements(board, i, j)) boardCopy[i][j] = boardCopy[i][j] + 2;
            }
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = boardCopy[i][j] / 2;
            }
        }
    }

    public boolean sumAdjacentElements(int[][] arr, int row, int col) {
        int sum = 0;

        for (int i = Math.max(0, row - 1); i <= Math.min(row + 1, arr.length - 1); i++) {
            for (int j = Math.max(0, col - 1); j <= Math.min(col + 1, arr[i].length - 1); j++) {
                sum += arr[i][j];
            }
        }
        sum -= arr[row][col]; // Исключаем сам элемент из суммы
        if (arr[row][col] == 1 && (2 <= sum && sum <= 3)) return true;
        if (arr[row][col] == 0 && (sum == 3)) return true;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] array = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        solution.gameOfLife(array);

        for (int[] ints : array) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
