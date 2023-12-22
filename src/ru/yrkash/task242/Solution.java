package ru.yrkash.task242;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> charMap = new HashMap<>();

        for (Character c : s.toCharArray()) {
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }
        for (Character c1: t.toCharArray()) {
            if (charMap.containsKey(c1) && (charMap.get(c1)) > 0) {
                charMap.put(c1, charMap.get(c1) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAnagram("anagram","nagaram"));
    }
}
