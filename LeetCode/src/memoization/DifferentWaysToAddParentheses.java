package memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParentheses {

    private Map<String, List<Integer>> memo;

    public List<Integer> diffWaysToCompute(String expression) {
        memo = new HashMap<>();
        return compute(expression);
    }

    private List<Integer> compute(String expression) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> left = compute(expression.substring(0, i));
                List<Integer> right = compute(expression.substring(i + 1));

                for (int l : left) {
                    for (int r : right) {
                        if (ch == '+') {
                            result.add(l + r);
                        } else if (ch == '-') {
                            result.add(l - r);
                        } else if (ch == '*') {
                            result.add(l * r);
                        }
                    }
                }
            }
        }

        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        memo.put(expression, result);

        return result;
    }

    public static void main(String[] args) {
        DifferentWaysToAddParentheses solution = new DifferentWaysToAddParentheses();
        String expression1 = "2-1-1";
        System.out.println(solution.diffWaysToCompute(expression1)); // Output: [2, 0]

        String expression2 = "2*3-4*5";
        System.out.println(solution.diffWaysToCompute(expression2)); // Output: [-34, -14, -10, -10, 10]
    }
}
