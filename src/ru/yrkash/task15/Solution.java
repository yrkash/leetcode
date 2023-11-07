package ru.yrkash.task15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;

        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue; // Skip duplicates
            }

            int left = i + 1;
            int right = length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates
                    while (left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

 /*   public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int [] sortNums = Arrays.stream(nums).sorted().toArray();
        int length = nums.length;
        int leftPointer = 0;
        int centralPointer = leftPointer++;
        int rightPointer = length - 1;
        int curSum;
        while (leftPointer != rightPointer - 1) {
            curSum = sortNums[leftPointer] + sortNums[centralPointer] + sortNums [rightPointer];
            if (curSum == 0) {
                List<Integer> triple = new ArrayList<>();
                triple.add(sortNums[leftPointer]);
                triple.add(sortNums[centralPointer]);
                triple.add(sortNums[rightPointer]);
                result.add(triple);
            }
        }
    }*/

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1,0,1,3,-1,-4};
        List<List<Integer>> result = solution.threeSum(nums);
        for(List<Integer> list: result) {
            System.out.println(list.get(0) + " " + list.get(1) + " " + list.get(2));
        }
    }
}
