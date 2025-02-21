package stack;

import java.util.Stack;

public class ValidParenthesis {

    public boolean isValid(String s) {

        if (s == null || s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParenthesis solution = new ValidParenthesis();

        // Test cases
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";

        System.out.println("Test Case 1: " + solution.isValid(s1)); // Output: true
        System.out.println("Test Case 2: " + solution.isValid(s2)); // Output: true
        System.out.println("Test Case 3: " + solution.isValid(s3)); // Output: false
        System.out.println("Test Case 4: " + solution.isValid(s4)); // Output: false
        System.out.println("Test Case 5: " + solution.isValid(s5)); // Output: true
    }

}
