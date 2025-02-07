package com.epam.bsp.stack;

import java.util.Stack;

public class Solution {

    public static int evaluateRpnTokens(String[] rpnTokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : rpnTokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int divisor = stack.pop();
                    stack.push(stack.pop() / divisor);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static boolean isValidParentheses(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.empty() || Math.abs(stack.pop() - c) > 2) {
                return false;
            }
        }
        return stack.empty();
    }
}