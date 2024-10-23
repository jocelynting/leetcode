package stack;

import java.util.Stack;

public class MinimumStringLengthAfterRemovingSubstrings {

    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }

            if (ch == 'B' && stack.peek() == 'A') {
                stack.pop();
            } else if (ch == 'D' && stack.peek() == 'C') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {
        MinimumStringLengthAfterRemovingSubstrings solution = new MinimumStringLengthAfterRemovingSubstrings();
        System.out.println(solution.minLength("CABABD")); // Output: 0
        System.out.println(solution.minLength("ACBDACBD")); // Output: 8
        System.out.println(solution.minLength("CABABDAB")); // Output: 0
        System.out.println(solution.minLength("ACBD")); // Output: 4
    }
}
