package ru.yrkash.task3;


import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        Set<Character> characterSet = new HashSet<>();
        int leftPointer = 0;
        int rightPointer = 0;
        int maxSize = 0;
        while (leftPointer < length && rightPointer < length)
        {
            while (characterSet.contains(s.charAt(rightPointer))) {
                characterSet.remove(s.charAt(leftPointer));
                leftPointer++;
            }
            characterSet.add(s.charAt(rightPointer));
            if (characterSet.size() > maxSize) maxSize = characterSet.size();
            rightPointer++;
        }
        return maxSize;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(str));
    }
}
