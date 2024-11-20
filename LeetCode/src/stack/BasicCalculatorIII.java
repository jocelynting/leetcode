package stack;

import java.util.Stack;

public class BasicCalculatorIII {
    public int calculate(String s) {
        return evaluate(s, 0)[0];
    }

    // Recursive helper function that returns the result and index after evaluation
    private int[] evaluate(String s, int index) {
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';

        while (index < s.length()) {
            char ch = s.charAt(index);

            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0');
            } else if (ch == '(') {
                int[] result = evaluate(s, index + 1);
                currentNumber = result[0];
                index = result[1];
            }

            // If ch is an operator or we reached the end, we need to evaluate
            if (!Character.isDigit(ch) && ch != ' ' || index == s.length() - 1) {
                if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = ch;
                currentNumber = 0;
            }

            if (ch == ')') {
                break;
            }

            index++;
        }

        // Sum up the stack for the final result of this evaluation
        int result = 0;
        for (int num : stack) {
            result += num;
        }

        return new int[]{result, index};
    }

    public static void main(String[] args) {
        BasicCalculatorIII solution = new BasicCalculatorIII();
        System.out.println(solution.calculate("2 + (3 + 1) *6 - 3")); // Output: 23
        System.out.println(solution.calculate(" 6-4/2 ")); // Output: 4
        System.out.println(solution.calculate("2*(5+5*2)/3+(6/2+8)")); // Output: 21
        System.out.println(solution.calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // Output: -12
    }
}
