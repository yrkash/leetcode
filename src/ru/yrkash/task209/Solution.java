package ru.yrkash.task209;

import java.util.Arrays;

public class Solution {


    public int minSubArrayLen(int target, int[] nums) {
        // Arrays.sort(nums);
        boolean isFirstSum = true;
        int length = nums.length;
        int leftPointer = 0;
        int sum = 0;
        int result = 0;
        for (int rightPointer = 0; rightPointer < length; rightPointer++) {
            sum += nums[rightPointer];
            while (sum >= target && leftPointer <= rightPointer)
            {
                if (isFirstSum) {
                    result = rightPointer - leftPointer + 1;
                    isFirstSum = false;
                }
                if (rightPointer - leftPointer + 1 < result) result = rightPointer - leftPointer + 1;
                sum -= nums[leftPointer];
                leftPointer++;
            }
        }
        return result;
    }


        public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] ar = new int[] {2,3,1,2,4,3};
        int[] ar = new int[] {10,2,3};
//        int[] ar = new int[] {1,2,3,4,5};
        System.out.println(solution.minSubArrayLen(6, ar));

    }
}
