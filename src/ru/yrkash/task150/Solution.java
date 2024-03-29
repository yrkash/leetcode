package ru.yrkash.task150;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class Solution {

    public int evalRPN(String[] tokens) {
        Set<String> operationSet = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Stack<Integer> result = new Stack<>();
        for (String component : tokens) {
            if (!operationSet.contains(component) && !component.isEmpty()) {
                result.push(Integer.parseInt(component));
            } else {
                int secondOperand = result.pop();
                int firstOperand = result.pop();
                int makeOperation = makeCalc(firstOperand, secondOperand, component);
                result.push(makeOperation);
            }
        }
        return result.pop();
    }
    public int makeCalc(int firstOperand, int secondOperand, String operation) {
        int result = switch (operation) {
            case "+" -> firstOperand + secondOperand;
            case "-" -> firstOperand - secondOperand;
            case "*" -> firstOperand * secondOperand;
            case "/" -> firstOperand / secondOperand;
            default -> 0;
        };
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] tokens = {"4","13","5","/","+"};

        System.out.println(solution.evalRPN(tokens));

    }
}

