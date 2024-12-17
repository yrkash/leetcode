package ru.yrkash.task35;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public int searchInsert(int[] nums, int target) {

        int startIndex = 0;
        int endIndex = nums.length;

        while (startIndex < endIndex) {
            int mid = (endIndex + startIndex) >> 1;
            if (nums[mid] >= target) {
                endIndex = mid;
            } else {
                startIndex = mid + 1;
            }
        }
        return startIndex;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,5,6};
        int result = solution.searchInsert(nums, 7);
        System.out.println(result);
    }
}
