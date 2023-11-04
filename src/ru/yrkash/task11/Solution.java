package ru.yrkash.task11;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int maxArea(int[] height) {
        int length = height.length;
        int leftIndex = 0;
        int rightIndex = length - 1;
        int maxArea = 0;
        while (leftIndex != rightIndex) {
            int curArea = Math.min(height[leftIndex],height[rightIndex]) * (rightIndex - leftIndex);
            if (maxArea < curArea) maxArea = curArea;
            if (height[leftIndex] > height[rightIndex]) rightIndex--;
            else {
                leftIndex++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height1 = {1,1};
        System.out.println(solution.maxArea(height1));
    }
}
