package ru.yrkash.task27;


public class Solution {


    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
            } else {
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num1 = new int[]{1,2,3,0,0,0};
        System.out.println(solution.removeElement(num1, 0));
    }
}
