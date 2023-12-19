package ru.yrkash.task383;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();
        for (Character c : magazine.toCharArray()) {
            if (magazineMap.containsKey(c)) {
                magazineMap.put(c, magazineMap.get(c) + 1);
            } else {
                magazineMap.put(c, 1);
            }
        }
        for (Character c1: ransomNote.toCharArray()) {
            if (magazineMap.containsKey(c1) && (magazineMap.get(c1)) > 0) {
                magazineMap.put(c1, magazineMap.get(c1) - 1);
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canConstruct("a1a","aab"));
    }
}
