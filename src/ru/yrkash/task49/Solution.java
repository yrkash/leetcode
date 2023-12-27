package ru.yrkash.task49;

import java.util.*;

public class Solution {


    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        List<String> strsList = new ArrayList<>(Arrays.stream(strs).toList());
        List<String> buffList = new ArrayList<>();
        int pointer = 0;
        while (pointer < strs.length) {
            buffList = new ArrayList<>();
            String currStr = strs[pointer];
            pointer++;
            if (!strsList.contains(currStr)) continue;
            buffList.add(currStr);
            strsList.remove(currStr);

            int counter = 0;
            while (counter < strsList.size()) {
                if (isAnagram(currStr, strsList.get(counter))) {
                    buffList.add(strsList.get(counter));
                    strsList.remove(counter);
                } else {
                    counter++;
                }
                if (!strsList.isEmpty()) {
                    if ((counter == strsList.size()) && (isAnagram(currStr, strsList.get(counter - 1)))) {
                        counter--;
                    }
                }
            }
            result.add(buffList);
        }
        return result;
    }
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
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        String[] strs2 = {"hhhhu","tttti","tttit","hhhuh","hhuhh","tittt"};
        String[] strs1 = {"","",""};
        List<List<String>> result = solution.groupAnagrams(strs);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
