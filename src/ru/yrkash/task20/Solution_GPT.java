package ru.yrkash.task20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution_GPT {
    public boolean isValid(String s) {
        Map<Character, Character> MAP = new HashMap<>();
        MAP.put('}', '{');
        MAP.put(')', '(');
        MAP.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (MAP.containsValue(c)) {
                stack.push(c);
            } else if (MAP.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != MAP.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }



    public static void main(String[] args) {
        Solution_GPT solution = new Solution_GPT();
        String str = "()[]{}";

        System.out.println(solution.isValid(str));

    }
}
