package ru.yrkash.task290;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;
        Map<Character, String> stringMap = new HashMap<>();
        Map<String, Character> reverseMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (stringMap.containsKey(pattern.charAt(i))) {
                if (!stringMap.get(pattern.charAt(i)).equals(words[i])) return false;
            } else {
                if (reverseMap.containsKey(words[i])) {
                    if (reverseMap.get(words[i]) != pattern.charAt(i)) return false;
                } else {
                    reverseMap.put(words[i], pattern.charAt(i));
                }
                stringMap.put(pattern.charAt(i), words[i]);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordPattern("aaaa","dog cat cat dog"));
    }
}
