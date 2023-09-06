package ru.yrkash.task238;

import java.util.Arrays;

public class Solution {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int [] leftArray = new int[length];
        int [] rightArray = new int[length];
        int [] result = new int[length];
        leftArray[0] = 1;
        rightArray [length - 1] = 1;
        for (int i = 1, j = length - 2; i < length; i++, j--) {
            leftArray[i] = leftArray [i - 1] * nums [i - 1];
            rightArray[j] = rightArray[j + 1] * nums [j + 1];
        }
        for (int i = 0; i < length; i++) {
            result[i] = leftArray[i] * rightArray[i];
        }
        return result;
    }

        public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ar = new int[] {1, 2, 3, 4};
        int [] res = solution.productExceptSelf(ar);
            for (int i = 0; i < ar.length; i++) {
                System.out.println(res[i]);
            }

    }
}
