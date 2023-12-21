package ru.yrkash.task205;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> stringMap = new HashMap<>();
        Map<Character, Character> reverseMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (stringMap.containsKey(s.charAt(i))) {
                if (stringMap.get(s.charAt(i)) != t.charAt(i)) return false;
            } else {
                if (reverseMap.containsKey(t.charAt(i))) {
                    if (reverseMap.get(t.charAt(i)) != s.charAt(i)) return false;
                } else {
                    reverseMap.put(t.charAt(i), s.charAt(i));
                }
                stringMap.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isIsomorphic("paper","title"));
    }
}
