package ru.yrkash.task219;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {


    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int length = nums.length;
        int rightPointer;
        int curCount = 0;
        for (int leftPointer = 0; leftPointer < length - 1; leftPointer++) {
            rightPointer = leftPointer + 1;
            while (nums[leftPointer] != nums[rightPointer] && rightPointer < length)
            {
                curCount++;
                rightPointer++;
                if (rightPointer == length) {
                    curCount = Integer.MAX_VALUE - 1;
                    break;
                }
            }

            curCount++;
            if (curCount <= k) {
                System.out.println(leftPointer + " " + rightPointer);
                return true;
            }
            else {
                curCount = 0;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicateGPT(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] ar = new int[] {2,3,1,2,4,3};
        int[] ar = new int[] {1,2,3,1,2,3};
//        int[] ar = new int[] {1,2,3,4,5};
        System.out.println(solution.containsNearbyDuplicate(ar, 2));

    }
}
