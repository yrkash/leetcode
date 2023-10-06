package ru.yrkash.task135;

import java.util.stream.IntStream;

public class Solution {

    public int candy(int[] ratings) {
        int [] candys = new int[ratings.length];
        candys[0] = 1;
//        from left to right
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings [i]) {
                candys [i + 1] = candys [i] + 1;
            } else {
                candys[i + 1] = 1;
            }
        }
        int sum = candys [ratings.length - 1];
//        from right to left
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings [i - 1] > ratings [i] && candys [i - 1] <= candys [i]) {
                candys [i - 1] = candys [i] + 1;
            }
            sum += candys [i - 1];
        }

        return sum;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = IntStream.of(gas).sum();
        int totalCost = IntStream.of(cost).sum();
        if (totalCost > totalGas) return -1;
        int index = 0;
        int currGas = gas[0];
        int currCost = cost[0];
        int diff = 0;
        for (int i = 1; i < gas.length ; i++) {
            diff += currGas - currCost;
            if (diff < 0) {
                diff = 0;
                index = i;
            }
            currGas = gas [i];
            currCost = cost [i];
        }
        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] rating = new int[]{1, 2, 2};
        System.out.println(solution.candy(rating));

    }
}
