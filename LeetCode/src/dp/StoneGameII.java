package dp;

public class StoneGameII {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffixSum = new int[n + 1];
        suffixSum[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        int[][] dp = new int[n][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                if (i + 2 * m >= n) {
                    dp[i][m] = suffixSum[i];
                } else {
                    for (int x = 1; x <= 2 * m; x++) {
                        int opponentScore = dp[i + x][Math.max(m, x)];
                        dp[i][m] = Math.max(dp[i][m], suffixSum[i] - opponentScore);
                    }
                }
            }
        }

        return dp[0][1];
    }

    public static void main(String[] args) {
        StoneGameII solution = new StoneGameII();
        int[] piles1 = {2, 7, 9, 4, 4};
        System.out.println(solution.stoneGameII(piles1));// Output: 10

        int[] piles2 = {1, 2, 3, 4, 5, 100};
        System.out.println(solution.stoneGameII(piles2));// Output: 104
    }
}

