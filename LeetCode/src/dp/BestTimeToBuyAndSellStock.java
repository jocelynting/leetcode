package dp;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int length = prices.length;
        // dp[i][0]代表第i天不持有股票的最大收益
        // dp[i][1]代表第i天持有股票的最大收益
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];;
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][0], -prices[i]);
        }
        return dp[length - 1][0];
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

        // Test case
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(prices)); // Output: 5
    }
}

