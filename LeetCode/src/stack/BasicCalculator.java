package stack;

import java.util.Enumeration;
import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i)))  {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                result += sign * num;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result *= stack.pop();
                result += stack.pop();
            }

        }

        return result;

    }

    public static void main(String[] args) {
        BasicCalculator solution = new BasicCalculator();
        String s = "(1 +( 4+5+2)-3)+(6+8)";
        System.out.println("Result: " + solution.calculate(s)); // Output: 23
    }

}
