package ru.yrkash.task26;


public class Solution {


    public int removeDuplicates(int[] nums) {
        int counter = 1;
        int curIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                counter++;
                curIndex++;
                nums[curIndex] = nums[i + 1];
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num1 = new int[]{1,2,3,3,3,4};
        System.out.println(solution.removeDuplicates(num1));
    }
}
