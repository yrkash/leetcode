package ru.yrkash.task122;

public class Solution {

    public int maxProfit(int[] prices) {
        int result = 0;
        int delta;
        for (int i = 0; i < prices.length - 1; i++) {
            delta = prices[i + 1] - prices[i];
            //buff += delta;
            if (delta > 0) result += delta;
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ar = new int[]{7,1,5,3,6,4};
        System.out.println(solution.maxProfit(ar));
//        System.out.println(solution.removeDuplicates(ar));
    }
}
