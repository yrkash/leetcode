package ru.yrkash.task13;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static final Map<String, Integer> romanDecMap = new HashMap<>();
    static {
        romanDecMap.put("I", 1);
        romanDecMap.put("V", 5);
        romanDecMap.put("X", 10);
        romanDecMap.put("L", 50);
        romanDecMap.put("C", 100);
        romanDecMap.put("D", 500);
        romanDecMap.put("M", 1000);
    }

    public int romanToInt(String s) {

        int result = 0;
        String[] chars = s.split("");
        result += romanDecMap.get(chars[chars.length - 1]);
        int prevValue = result;
        if (chars.length >= 2) {
            for (int i = chars.length - 2; i >= 0 ; i--) {
                int curValue = romanDecMap.get(chars[i]);
                if (curValue < prevValue) {
                    result -= curValue;
                } else {
                    result += curValue;
                }
                prevValue = curValue;
            }
        }
        return result;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "MCMXCIV";
        System.out.println(solution.romanToInt(str));
    }
}
