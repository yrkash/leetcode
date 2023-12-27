package ru.yrkash.task49;

import java.util.*;

public class Solution_GPT {


    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            if (!anagramMap.containsKey(sortedStr)) {
                anagramMap.put(sortedStr, new ArrayList<>());
            }
            anagramMap.get(sortedStr).add(str);
        }

        for (List<String> anagramGroup : anagramMap.values()) {
            result.add(anagramGroup);
        }

        return result;
    }


    public static void main(String[] args) {
        Solution_GPT solution = new Solution_GPT();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        String[] strs2 = {"hhhhu","tttti","tttit","hhhuh","hhuhh","tittt"};
        String[] strs1 = {"","",""};
        List<List<String>> result = solution.groupAnagrams(strs);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
