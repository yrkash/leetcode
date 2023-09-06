package ru.yrkash.task80;

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
                if ((nums[i + 1] == nums[i]) && isTwice == false) {
                    counter++;
                    curIndex++;
                    nums[curIndex] = nums[i + 1];
                    isTwice = true;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ar = new int[]{1,1,1,2,2,3};
        System.out.println(solution.removeDuplicates(ar));
    }
}
