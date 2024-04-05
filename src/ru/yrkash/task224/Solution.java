package ru.yrkash.task224;

import java.util.List;
import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop(); // multiply with the sign before the parenthesis
                result += stack.pop(); // add the result before the parenthesis
            }
        }

        if (number != 0) {
            result += sign * number;
        }

        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String expression = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(solution.calculate(expression));
    }
}

