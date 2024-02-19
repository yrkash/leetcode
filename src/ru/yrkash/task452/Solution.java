package ru.yrkash.task452;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1) {
            return 1;
        }
        // Сортировка интервалов по начальному значению
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int result = 1;
        int[] currentInterval = points[0];
        for (int i = 1; i <  points.length; i++) {
            if (currentInterval[1] < points[i][0]) {
                currentInterval = points[i];
                result++;
                continue;
            }

            if (currentInterval[1] <= points[i][1]) {
                currentInterval[0] = points[i][0];
            }
        }
        return result;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] array = {{2, 6}, {1, 3}, {8, 10}, {15, 18}};
        int[][] array = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int result = solution.findMinArrowShots(array);
        System.out.println(result);

    }
}
