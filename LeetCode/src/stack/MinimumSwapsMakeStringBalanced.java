package stack;

import java.util.Stack;

public class MinimumSwapsMakeStringBalanced {

    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '[') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    count++;
                }
            }
        }

        return (count + 1) / 2;
    }

    public static void main(String[] args) {
        MinimumSwapsMakeStringBalanced solution = new MinimumSwapsMakeStringBalanced();
        System.out.println(solution.minSwaps("][]["));// Output: 1
        System.out.println(solution.minSwaps("]]][[[["));// Output: 2
        System.out.println(solution.minSwaps("[]"));// Output: 0
    }
}
