package stack;

import java.util.Stack;

public class ValidParenthesisString {

    public boolean checkValidString(String s) {

        Stack<Integer> brackets = new Stack<>();
        Stack<Integer> asterisks = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                brackets.push(i);
            } else if (c == '*') {
                asterisks.push(i);
            } else {
                if (!brackets.isEmpty()){
                    brackets.pop();
                } else if (!asterisks.isEmpty()) {
                    asterisks.pop();
                } else {
                    return false;
                }
            }
        }

        while (!brackets.isEmpty() && !asterisks.isEmpty()){
            int b = brackets.pop();
            int a = asterisks.pop();
            if (b > a) {
                return false;
            }
        }

        return brackets.isEmpty();

    }

    public static void main(String[] args) {
        ValidParenthesisString solution = new ValidParenthesisString();

        // Test cases
        String s1 = "()";
        String s2 = "(*)";
        String s3 = "(*))";
        String s4 = "(((*)";

        System.out.println("Test Case 1: " + solution.checkValidString(s1)); // Output: true
        System.out.println("Test Case 2: " + solution.checkValidString(s2)); // Output: true
        System.out.println("Test Case 3: " + solution.checkValidString(s3)); // Output: true
        System.out.println("Test Case 4: " + solution.checkValidString(s4)); // Output: false
    }
}
