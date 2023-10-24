package ru.yrkash.task151;


public class Solution {



    public String reverseWords(String s) {
        String str = s.trim();
        String[] words = str.split("\\s+");

        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1;  i >= 0; i--) {
            result.append(words[i] + " ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "a good   example";
        System.out.println(solution.reverseWords(str));

    }
}
