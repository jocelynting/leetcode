package greedy;

public class MinimumAddMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    result++;
                }
            }
        }

        return result + open;
    }

    public static void main(String[] args) {
        MinimumAddMakeParenthesesValid solution = new MinimumAddMakeParenthesesValid();
        System.out.println(solution.minAddToMakeValid("())")); // Output: 1
        System.out.println(solution.minAddToMakeValid("(((")); // Output: 3
        System.out.println(solution.minAddToMakeValid("()")); // Output: 0
        System.out.println(solution.minAddToMakeValid("()))((")); // Output: 4
    }
}
