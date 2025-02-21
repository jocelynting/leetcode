package dp;

public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0;
        for (int stone : stones) {
            totalSum += stone;
        }

        int n = stones.length;
        int target = totalSum / 2;
        int[][] dp = new int[n][target + 1];

        for (int j = stones[0]; j <= target ; j++) {
            dp[0][j] = stones[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target ; j++) {
                if (j < stones[i]){
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                }
            }
        }

        return totalSum - 2 * dp[n - 1][target];

    }

    public static void main(String[] args) {
        LastStoneWeightII solution = new LastStoneWeightII();

        // Test case
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(solution.lastStoneWeightII(stones)); // Output: 1
    }
}

