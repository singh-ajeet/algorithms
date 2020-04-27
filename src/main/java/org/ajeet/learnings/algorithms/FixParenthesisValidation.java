package org.ajeet.learnings.algorithms;

import java.util.Stack;

public final class FixParenthesisValidation {

    public static String fix(String input) {
        if (input == null || input.isEmpty())
            throw new IllegalArgumentException("Input string must not be empty or null.");
        return fix_(input);
    }

    private static String fix_(String input) {
        if(isValid(input))
            return input;
        for (int i=0; i<input.length(); i++) {
            String subStr = removeChar(input, i);
            if(isValid(subStr))
                return subStr;
        }
        for (int i=0; i<input.length(); i++) {
            String subStr = removeChar(input, i);
            return fix_(subStr);
        }
        return null;
    }

    private static String removeChar(String input, int pos) {
        return input.substring(0, pos) + input.substring(pos + 1, input.length());
    }

    private static boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<input.length(); i++) {
            char ch = input.charAt(i);
            if( ch == '(')
                stack.push(ch);
            else if (ch == ')' && !stack.isEmpty())
                stack.pop();
            else if(stack.isEmpty() && ch == ')')
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(fix("("));
    }
}
