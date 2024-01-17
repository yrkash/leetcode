package ru.yrkash.task202;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public boolean isHappy(int n) {
        Set<Integer> encounteredNums = new HashSet<>();
        while (n != 1 && !encounteredNums.contains(n)) {
            encounteredNums.add(n);
            n = calculateSumOfSquares(n);
        }
        return n == 1;
    }

    private static int calculateSumOfSquares(int num) {
        int sumOfSquares = 0;
        while (num > 0) {
            int digit = num % 10;
            sumOfSquares += digit * digit;
            num /= 10;
        }
        return sumOfSquares;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(2));
    }
}
