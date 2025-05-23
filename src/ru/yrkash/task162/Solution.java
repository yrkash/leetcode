package ru.yrkash.task162;


public class Solution {


    public int findPeakElement(int[] nums) {
        int left = 0; // Initialize the left boundary of the search space
        int right = nums.length - 1; // Initialize the right boundary of the search space

        // Continue the loop until the search space is reduced to one element
        while (left < right) {
            // Calculate the middle index of the current search space
            int mid = left + (right - left) / 2;

            // If the middle element is greater than its next element, then a peak must be to the left (including mid)
            if (nums[mid] > nums[mid + 1]) {
                // Narrow the search space to the left half
                right = mid;
            } else {
                // Otherwise, the peak exists in the right half (excluding mid)
                // Narrow the search space to the right half
                left = mid + 1;
            }
        }

        // When left == right, we have found the peak element's index, return it
        return left;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,1,1,1};
        System.out.println(solution.findPeakElement(nums1));
    }
}
