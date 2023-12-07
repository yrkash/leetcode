package ru.yrkash.task73;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public void setZeroes(int[][] matrix) {
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowHasZero) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstColHasZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    /*public void setZeroes(int[][] matrix) {
        boolean firstIsNull = false;
        if (matrix[0][0] == 0) firstIsNull = true;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix [i][0] = 0;
                    matrix [0][j] = 0;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix [i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("__________________");

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstIsNull) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }*/

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] array = {
//                {1, 2, 3, 4},
//                {5, 0, 7, 8},
//                {0, 10, 11, 12},
//                {13, 14, 15, 0}
//        };

//        int[][] array = {
//                {1, 1, 1},
//                {1, 0, 1},
//                {1, 1, 1}
//        };

//        int[][] array = {
//                {1, 0, 3}
//        };
        int[][] array = {
                {1, 0, 3},
                {2, 1, 3}
        };
        solution.setZeroes(array);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
