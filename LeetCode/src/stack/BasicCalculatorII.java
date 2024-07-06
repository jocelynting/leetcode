package stack;

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int num = 0;
        int operator = '+';

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                if (operator == '+') {
                    stack.push(num);
                } else if (operator == '-') {
                    stack.push(-num);
                } else if (operator == '*') {
                    stack.push(stack.pop() * num);
                } else if (operator == '/') {
                    stack.push(stack.pop() / num);
                }
                operator = ch;
                num = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        BasicCalculatorII solution = new BasicCalculatorII();

        System.out.println(solution.calculate("3+2*2")); // Expected output: 7
        System.out.println(solution.calculate(" 3/2 ")); // Expected output: 1
        System.out.println(solution.calculate(" 3+5 / 2 ")); // Expected output: 5
        System.out.println(solution.calculate(" 14-3/2 ")); // Expected output: 13
    }
}
