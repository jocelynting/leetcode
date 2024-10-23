package stack;

import java.util.Stack;

public class MinimumAddMakeParenthesesValid {

    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    result++;
                } else {
                    stack.pop();
                }
            }
        }

        return result + stack.size();
    }

    public static void main(String[] args) {
        MinimumAddMakeParenthesesValid solution = new MinimumAddMakeParenthesesValid();
        System.out.println(solution.minAddToMakeValid("())")); // Output: 1
        System.out.println(solution.minAddToMakeValid("(((")); // Output: 3
        System.out.println(solution.minAddToMakeValid("()")); // Output: 0
        System.out.println(solution.minAddToMakeValid("()))((")); // Output: 4

    }
}
