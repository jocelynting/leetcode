package dp;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    public static void main(String[] args) {
        MinCostClimbingStairs solution = new MinCostClimbingStairs();
        int[] cost = {10, 15, 20};
        System.out.println(solution.minCostClimbingStairs(cost)); // Output: 15
    }
}

