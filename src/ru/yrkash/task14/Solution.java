package ru.yrkash.task14;

public class Solution {



    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char buffChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i) return result.toString();
                if (strs[j].charAt(i) != buffChar) return result.toString();
            }
            result.append(buffChar);
        }
        return result.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"ab", "a"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
}
