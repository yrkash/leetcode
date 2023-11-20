package ru.yrkash.task76;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public String minWindow(String s, String t) {
        String result = new String();
        int resultLength = Integer.MAX_VALUE;
        int tLength = t.length();
        int sLength = s.length();
        if (tLength > sLength) return result;
        HashMap<Character, Integer> hashMap = new HashMap();
        for (int i = 0; i < tLength; i++)
        {
            hashMap.put(t.charAt(i), hashMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (int leftPointer = 0; leftPointer <= sLength - tLength; leftPointer++)
        {
            HashMap<Character, Integer> tempMap = (HashMap<Character, Integer>) hashMap.clone();

            int rightPointer = leftPointer, count = tLength;
            if (hashMap.containsKey(s.charAt(leftPointer))) {
                // Traverse the substring
                while (rightPointer < sLength)
                {
                    Character curChar = s.charAt(rightPointer);
                    if (tempMap.containsKey(curChar) && tempMap.get(curChar) > 0) {
                        tempMap.put(curChar, tempMap.get(curChar) - 1);
                        count--;
                    }
                    rightPointer++;
                    if (count == 0) break;
                }
                if (count == 0) {
                    String buffResult = s.substring(leftPointer, rightPointer);
//                    System.out.println(buffResult);
                    if (buffResult.length() < resultLength) {
                        result = buffResult;
                        resultLength = result.length();
                    }
                }
            }
        }
        return result;
    }

    public String minWindowSubstring(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        // Create a HashMap to store the frequency of each character in t
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int left = 0; // Start index of the window
        int right = 0; // End index of the window
        int windowStart = 0; // Start index of the minimum window
        int windowSize = Integer.MAX_VALUE; // Size of the minimum window
        int count = t.length(); // Number of characters remaining to be found

        while (right < s.length()) {
            char rightChar = s.charAt(right);

            if (targetMap.containsKey(rightChar)) {
                targetMap.put(rightChar, targetMap.get(rightChar) - 1);
                if (targetMap.get(rightChar) >= 0) {
                    count--;
                }
            }
            while (count == 0) {
                if (right - left + 1 < windowSize) {
                    windowSize = right - left + 1;
                    windowStart = left;
                }

                char leftChar = s.charAt(left);

                if (targetMap.containsKey(leftChar)) {
                    targetMap.put(leftChar, targetMap.get(leftChar) + 1);
                    if (targetMap.get(leftChar) > 0) {
                        count++;
                    }
                }

                left++;
            }

            right++;
        }

        if (windowSize == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(windowStart, windowStart + windowSize);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "ADOBECODEBANC";
        String t = "ABC";
        String result = solution.minWindowSubstring(str, t);
        System.out.println(result);
    }
}
