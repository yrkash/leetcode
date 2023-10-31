package ru.yrkash.task125;

public class Solution {

    public boolean isPalindrome(String s) {
        String str1 = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        String str2 = (new StringBuilder(str1)).reverse().toString();
        return (str1.equals(str2));
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "0P";
        System.out.println(solution.isPalindrome(str));
    }
}
