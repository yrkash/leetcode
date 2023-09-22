package ru.yrkash.task42;

import java.util.LinkedList;

public class Solution {

    public int removeDuplicates(int[] nums) {
        int counter = 1;
        int curIndex = 0;
        boolean isTwice = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                counter++;
                curIndex++;
                nums[curIndex] = nums[i + 1];
                isTwice = false;
            } else {
                if ((nums[i + 1] == nums[i]) && !isTwice) {
                    counter++;
                    curIndex++;
                    nums[curIndex] = nums[i + 1];
                    isTwice = true;
                }
            }
        }
        return counter;
    }

    public int trap(int[] height) {
        int length = height.length;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int trapSum = 0;
        leftMax[0] = height[0];
        rightMax[length - 1] = height[length - 1];

        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            rightMax[length - i - 1] = Math.max(rightMax[length - i], height[length - i - 1]);
        }

        for (int i = 0; i < length; i++) {
            trapSum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return trapSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ar = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(ar));
    }
}
