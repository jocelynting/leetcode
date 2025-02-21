package dp;

public class MaximumNumberOfMovesInGrid {

    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        int result = 0;

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] > grid[i][j - 1] && dp[i][j - 1] > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
                }

                if (i > 0 && grid[i][j] > grid[i - 1][j - 1] &&
                        dp[i - 1][j - 1] > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }

                if (i < m - 1 && grid[i][j] > grid[i + 1][j - 1] &&
                        dp[i + 1][j - 1] > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 1);
                }

                result = Math.max(result, dp[i][j] - 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumNumberOfMovesInGrid solution = new MaximumNumberOfMovesInGrid();
        int[][] grid = {
                {2, 4, 3, 5},
                {5, 4, 9, 3},
                {3, 4, 2, 11},
                {10, 9, 13, 15}
        };

        System.out.println(solution.maxMoves(grid));// Output: 3
    }
}
