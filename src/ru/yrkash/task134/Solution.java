package ru.yrkash.task134;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class Solution {

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
        int[] gas = new int[]{2, 3, 4};
        int[] cost = new int[]{3, 4, 3};
        System.out.println(solution.canCompleteCircuit(gas, cost));

    }
}
