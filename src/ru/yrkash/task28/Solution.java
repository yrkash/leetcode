package ru.yrkash.task28;


public class Solution {


    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "1saadbutsad";
        System.out.println(solution.strStr(str, "sad"));
    }
}
