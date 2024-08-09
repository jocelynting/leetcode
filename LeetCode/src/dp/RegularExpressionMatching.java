package dp;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // if s is empty, fill the dp table for patterns like a*, a*b*, a*b*c* that match an empty string
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    /*
                        * 代表零个前面的字符：
	                    如果 * 代表零个前面的字符，则 p 中的 * 及其前面的字符对当前 s[0...i-1] 没有任何影响。
	                    这时，我们只需要看 p 中去掉 * 和其前面的字符后，是否匹配 s[0...i-1]。
	                    因此，我们可以通过 dp[i][j] = dp[i][j - 2] 来表示这种情况，其中 j - 2 是去掉 * 和它前面的字符后的状态。

	                    * 代表一个或多个前面的字符：
	                    如果 * 代表一个或多个前面的字符，前面的字符必须与当前 s[i - 1] 匹配，
	                    或者前面的字符是 .（可以匹配任何字符）。在这种情况下，我们还需要考虑 dp[i - 1][j]，
	                    即在 s 中去掉一个字符后是否可以匹配 p。这说明我们还需要检查 dp[i - 1][j]，
	                    即 s 向前移动一位，仍然保持 p 含有 *。
                     */
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        RegularExpressionMatching solution = new RegularExpressionMatching();
        System.out.println(solution.isMatch("aa", "a"));        // Output: false
        System.out.println(solution.isMatch("aa", "a*"));       // Output: true
        System.out.println(solution.isMatch("ab", ".*"));       // Output: true
        System.out.println(solution.isMatch("aab", "c*a*b"));   // Output: true
        System.out.println(solution.isMatch("mississippi", "mis*is*p*.")); // Output: false
    }
}
