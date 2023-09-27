package ru.yrkash.task12;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static final Map<Integer, String> romanDecMap = new HashMap<>();
    private static final int[] numbers = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static {
        romanDecMap.put(1, "I");
        romanDecMap.put(4, "IV");
        romanDecMap.put(5, "V");
        romanDecMap.put(9, "IX");
        romanDecMap.put(10, "X");
        romanDecMap.put(40, "XL");
        romanDecMap.put(50, "L");
        romanDecMap.put(90, "XC");
        romanDecMap.put(100, "C");
        romanDecMap.put(400, "CD");
        romanDecMap.put(500, "D");
        romanDecMap.put(900, "CM");
        romanDecMap.put(1000, "M");
    }

    public String intToRoman(int num) {
        int buff = num;
        StringBuilder result = new StringBuilder();
        while (buff > 0) {
            for (int i = 0; i < numbers.length; i++) {
                while (buff >= numbers[i]) {
                    result.append(romanDecMap.get(numbers[i]));
                    buff -= numbers[i];
                }
            }
        }
        return result.toString();
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = 1994;
        System.out.println(solution.intToRoman(number));
    }
}
