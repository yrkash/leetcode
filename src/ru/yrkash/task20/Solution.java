package ru.yrkash.task20;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class Solution {

    public boolean isValid(String s) {
        Map<Character, Character> MAP = new HashMap<>();
        MAP.put('}','{');
        MAP.put(')','(');
        MAP.put(']','[');

        int length = s.length();
        if ((length % 2 != 0) || (length == 0)) return false;
        Stack<Character> stack = new Stack<>();
        Character curChar = s.charAt(0);
        String charToString = String.valueOf(curChar);
        if (charToString.matches("[)}\\]]")) {
            return false;
        }
        stack.push(curChar);
        for (int i = 1; i < length; i++) {
            curChar = s.charAt(i);
            charToString = String.valueOf(curChar);
            if (charToString.matches("[({\\[]")) stack.push(curChar);
            if (charToString.matches("[)}\\]]")) {
                if (stack.empty()) return false;
                Character prevChar = stack.pop();
                if (!MAP.get(curChar).equals(prevChar)) {
                    return false;
                }
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "()[]{}";

        System.out.println(solution.isValid(str));

    }
}
