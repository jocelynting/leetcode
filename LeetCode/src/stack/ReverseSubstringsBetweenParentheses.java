package stack;

import java.util.Stack;

public class ReverseSubstringsBetweenParentheses {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
                for (char c : sb.toString().toCharArray()) {
                    stack.push(c);
                }
            } else {
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ReverseSubstringsBetweenParentheses solution = new ReverseSubstringsBetweenParentheses();
        System.out.println(solution.reverseParentheses("(abcd)")); // Output: "dcba"
        System.out.println(solution.reverseParentheses("(u(love)i)")); // Output: "iloveu"
        System.out.println(solution.reverseParentheses("(ed(et(oc))el)")); // Output: "leetcode"
        System.out.println(solution.reverseParentheses("a(bcdefghijkl(mno)p)q")); // Output: "apmnolkjihgfedcbq"
    }
}
