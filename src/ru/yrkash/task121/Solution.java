package ru.yrkash.task121;

import java.util.LinkedList;

public class Solution {

    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int buff = prices[i + 1] - prices[i];
            if (buff > result) result = buff;

            System.out.println(result);
        }
        return (result < 0) ? 0 : result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ar = new int[]{1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(ar));
//        System.out.println(solution.removeDuplicates(ar));
    }
}
