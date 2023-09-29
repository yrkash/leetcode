package ru.yrkash.task58;

public class Solution {

    public int lengthOfLastWord(String s) {
        String strWithoutLastSpace = s.trim();
        char[] symbols = strWithoutLastSpace.toCharArray();
        int lengthOfLastWord = 0;
        for (int i = strWithoutLastSpace.length() - 1; i >= 0 ; i--) {
            char curChar = symbols[i];
            if (curChar != 32) lengthOfLastWord++;
            else {
                break;
            }
        }
        return lengthOfLastWord;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String text = "luffy is still joyboy";
        System.out.println(solution.lengthOfLastWord(text));
    }
}
