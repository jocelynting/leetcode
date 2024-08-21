package dp;

public class StrangePrinter {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int diff = 2; diff <= n; diff++) {
            for (int i = 0; i <= n - diff; i++) {
                int j = i + diff - 1;
                dp[i][j] = dp[i][j - 1] + 1;
                for (int k = i; k < j; k++) {
                    if (s.charAt(k) == s.charAt(j)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] - 1);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        StrangePrinter solution = new StrangePrinter();
        System.out.println(solution.strangePrinter("aaabbb"));// Output: 2
        System.out.println(solution.strangePrinter("aba"));// Output: 2
    }
}
