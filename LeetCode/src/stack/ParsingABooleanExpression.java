package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParsingABooleanExpression {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == ',') {
                continue;
            } else if (c == ')') {
                List<Character> sub = new ArrayList<>();
                while (stack.peek() != '(') {
                    sub.add(stack.pop());
                }
                stack.pop();
                char operator = stack.pop();
                char result = subExpression(operator, sub);
                stack.push(result);
            } else {
                stack.push(c);
            }
        }
        return stack.pop() == 't';
    }

    private char subExpression(char operator, List<Character> sub) {
        if (operator == '!') {
            return sub.get(0) == 't' ? 'f' : 't';
        } else if (operator == '&') {
            for (char c : sub) {
                if (c == 'f') {
                    return 'f';
                }
            }
            return 't';
        } else if (operator == '|') {
            for (char c : sub) {
                if (c == 't') {
                    return 't';
                }
            }
            return 'f';
        }
        return 'f';
    }

    public static void main(String[] args) {
        ParsingABooleanExpression solution = new ParsingABooleanExpression();
        System.out.println(solution.parseBoolExpr("&(|(f))")); // false
        System.out.println(solution.parseBoolExpr("|(f,f,f,t)")); // true
        System.out.println(solution.parseBoolExpr("!(&(f,t))")); // true
    }
}
