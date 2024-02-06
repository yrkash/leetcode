package ru.yrkash.task57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];
        int length = intervals.length;
        int index = 0;
        List<int[]> list = new ArrayList<>();
        while (index < length) {
            if (intervals[index][1] < start) {
                list.add(intervals[index]);
                index++;
            } else {
                break;
            }
        }
        while (index < length) {
            if (intervals[index][0] <= end) {
                start = Math.min(start, intervals[index][0]);
                end = Math.max(end, intervals[index][1]);
                index++;
            } else {
                break;
            }
        }
        list.add(new int[]{start, end});
        // no overlap
        while (index < length) {
            list.add(intervals[index]);
            index++;
        }
        int[][] result = new int[list.size()][];
        list.toArray(result);
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] array = {{2, 6}, {1, 3}, {8, 10}, {15, 18}};
        int[][] array = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12,16}};
        int[] insertArray = {4,8};
        int[][] result = solution.insert(array, insertArray);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + ", " + result[i][1]);
        }

    }
}
