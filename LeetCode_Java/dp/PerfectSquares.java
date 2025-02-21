package dp;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        for (int j = 0; j < dp.length; j++) {
            dp[j] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares solution = new PerfectSquares();

        // Test case
        int n = 12;
        System.out.println(solution.numSquares(n)); // Output: 3 (12 = 4 + 4 + 4)
    }
}

