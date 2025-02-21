package stack;

import java.util.Stack;

public class RemovingStarsFromString {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                if (stack.isEmpty()) {
                    continue;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        RemovingStarsFromString solution = new RemovingStarsFromString();
        String s1 = "leet**cod*e";
        System.out.println(solution.removeStars(s1)); // Output: lecoe

        String s2 = "erase*****";
        System.out.println(solution.removeStars(s2)); // Output: ""
    }
}
