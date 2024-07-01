package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(result, "", 0, 0, n);
        return result;
    }

    private void backtracking(List<String> result, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            result.add(cur);
            return;
        }

        if (open < max) {
            backtracking(result, cur + "(", open + 1, close, max);
        }

        if (close < open) {
            backtracking(result, cur + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();

        System.out.println(solution.generateParenthesis(3)); // Output: ["((()))", "(()())", "(())()", "()(())", "()()()"]
        System.out.println(solution.generateParenthesis(1)); // Output: ["()"]
    }
}
