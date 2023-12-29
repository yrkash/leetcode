package ru.yrkash.task1;

import java.util.HashMap;
import java.util.Map;

public class Solution {


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numsMap.containsKey(complement)) {
                return new int[]{numsMap.get(complement), i};
            }
            numsMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,7,11,15};
        int[] nums1 = {3,3};
        int [] result = solution.twoSum(nums, 9);
        System.out.println(result[0] + " " + result[1]);
    }
}
