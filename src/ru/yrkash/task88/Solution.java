package ru.yrkash.task88;

public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If there are any remaining elements in nums2, copy them into nums1
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        for (int l = 0; l < nums1.length; l++) {
            System.out.print(nums1[l] + " ");
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num1 = new int[]{1,2,3,0,0,0};
        int[] num2 = new int[]{2,5,6};
        solution.merge(num1,3, num2,3);
    }
}
