package stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> match = new Stack<>();
        Set<Integer> notMatch = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                match.push(i);
            } else if (ch == ')') {
                if (!match.isEmpty()) {
                    match.pop();
                } else {
                    notMatch.add(i);
                }
            }
        }

        while (!match.isEmpty()) {
            notMatch.add(match.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!notMatch.contains(i)) {
                char ch = s.charAt(i);
                sb.append(ch);
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        MinimumRemoveToMakeValidParentheses solution = new MinimumRemoveToMakeValidParentheses();
        System.out.println(solution.minRemoveToMakeValid("lee(t(c)o)de)"));// Output: "lee(t(c)o)de"
        System.out.println(solution.minRemoveToMakeValid("a)b(c)d"));// Output: "ab(c)d"
        System.out.println(solution.minRemoveToMakeValid("))(("));// Output: ""
    }
}
