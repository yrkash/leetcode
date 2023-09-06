package ru.yrkash.task189;

import java.util.Arrays;
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

    public void rotate(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            int buff = list.getLast();
            list.add(0,buff);
            list.pollLast();
        }
        Integer[] result = list.toArray(new Integer[nums.length]);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result [i];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ar = new int[]{1,2,3,4,5,6,7};
        solution.rotate(ar, 3);
        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }
//        System.out.println(solution.removeDuplicates(ar));
    }
}
