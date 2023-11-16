package ru.yrkash.task30;


import java.util.*;

public class Solution {

    public List<Integer> findSubstring(String s, String[] words)  {
        int wordSize = words[0].length();
        int countOfWords = words.length;
        int wordsLength = wordSize * countOfWords;
        ArrayList<Integer> result = new ArrayList();
        int n = s.length();
        if (wordsLength > n)
        {
            return result;
        }
        HashMap<String, Integer> hashMap = new HashMap();
        for (String word : words)
        {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i <= n - wordsLength; i++)
        {
            HashMap<String, Integer> tempMap =
                    (HashMap<String, Integer>) hashMap.clone();
            int j = i, count = countOfWords;
            // Traverse the substring
            while (j < i + wordsLength)
            {
                // Extract the word
                String word = s.substring(j, j + wordSize);

                // If word not found or if frequency
                // of current word is more than required simply break.
                if (!hashMap.containsKey(word) || tempMap.get(word) == 0) break;

                // Else decrement the count of word from hash_map
                else
                {
                    tempMap.put(word, tempMap.get(word) - 1);
                    count--;
                }
                j += wordSize;
            }

            if (count == 0) result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        List<Integer> result = solution.findSubstring(str, words);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
