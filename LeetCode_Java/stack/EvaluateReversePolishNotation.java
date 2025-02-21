package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {

            switch (s) {
                case "+" -> {
                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(first + second);
                }
                case "-" -> {
                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(first - second);
                }
                case "*" -> {
                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(first * second);
                }
                case "/" -> {
                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(first / second);
                }
                default -> stack.push(Integer.parseInt(s));
            }

        }

        return stack.pop();
    }


    public static void main(String[] args) {
        EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();

        // Test case
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println("Result: " + solution.evalRPN(tokens1)); // Output: 9
        System.out.println("Result: " + solution.evalRPN(tokens2)); // Output: 6
    }
}
