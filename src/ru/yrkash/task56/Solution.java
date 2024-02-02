package ru.yrkash.task56;

import java.util.*;

public class Solution {


    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        // Сортировка интервалов по начальному значению
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= currentInterval[1]) {
                // Интервалы перекрываются, так что объединяем их
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                // Интервалы не перекрываются, добавляем текущий интервал в результат и обновляем текущий интервал
                result.add(currentInterval);
                currentInterval = intervals[i];
            }
        }

        // Добавляем последний текущий интервал в результат
        result.add(currentInterval);

        return result.toArray(new int[result.size()][]);
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] array = {{2, 6}, {1, 3}, {8, 10}, {15, 18}};
        int[][] result = solution.merge(array);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + ", " + result[i][1]);
        }

    }
}
