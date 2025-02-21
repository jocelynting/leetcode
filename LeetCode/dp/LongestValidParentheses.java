package dp;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int longest = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (
                        i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '('
                ) {
                    dp[i] = dp[i - 1] +
                            ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) +
                            2;
                }
                longest = Math.max(longest, dp[i]);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestValidParentheses solution = new LongestValidParentheses();
        String s = "(()))())(";
        System.out.println(solution.longestValidParentheses(s)); // Expected output: 4
    }
}
