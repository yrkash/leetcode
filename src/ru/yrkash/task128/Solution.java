package ru.yrkash.task128;

import java.util.*;

public class Solution {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        int maxLength;
        if (nums.length > 0) {
            maxLength = 1;
        } else {
            return 0;
        }
        for (Integer elem:nums) {
            set.add(elem);
        }
        int curLength = 1;

        for (Integer elem: set) {
            if (set.contains(elem + 1)) curLength++;
            else {
                if (curLength > maxLength) maxLength = curLength;
                curLength = 1;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] ar = new int[] {2,3,1,2,4,3};
        int[] ar = new int[] {0,3,7,2,5,8,4,6,0,1};
//        int[] ar = new int[] {1,2,3,4,5};
        System.out.println(solution.longestConsecutive(ar));

    }
}
