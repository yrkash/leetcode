package ru.yrkash.task48;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public void rotate(int[][] matrix) {
        int[][] result = rotateLeft(matrix);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                matrix[i][j] = result [i][j];
            }
        }
    }

    private static int[][] rotateLeft(int[][] array) {
        int rowCount = array.length;
        int colCount = array[0].length;

        int[][] result = new int[colCount][rowCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                result[j][colCount - i - 1] = array[i][j];
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        solution.rotate(array);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
