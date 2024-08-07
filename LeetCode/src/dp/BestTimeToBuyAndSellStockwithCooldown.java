package dp;

public class BestTimeToBuyAndSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        // dp[i][0]: 第i天结束时，不持有股票的最大利润
        // dp[i][1]: 第i天结束时，持有股票的最大利润

        // 初始化第0天和第1天的状态
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            // 不持有股票的状态：
            // 1. 前一天也不持有股票
            // 2. 前一天持有股票，今天卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

            // 持有股票的状态：
            // 1. 前一天就持有股票
            // 2. 前天不持有股票（考虑冷冻期），今天买入
            dp[i][1] = Math.max(dp[i - 1][1], (i >= 2 ? dp[i - 2][0] : 0) - prices[i]);
        }

        // 最后一天不持有股票的状态就是最大利润
        return dp[n - 1][0];
        /*
        int n = prices.length;

        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] cooldown = new int[n];

        buy[0] = -prices[0];
        sell[0] = 0;
        cooldown[0] = 0;

        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i - 1], cooldown[i - 1] - prices[i]);
            sell[i] = buy[i - 1] + prices[i];
            cooldown[i] = Math.max(sell[i - 1], cooldown[i - 1]);
        }

        return Math.max(sell[n - 1], cooldown[n - 1]);
         */
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockwithCooldown solution = new BestTimeToBuyAndSellStockwithCooldown();
        int[] prices1 = {1, 2, 3, 0, 2};
        System.out.println(solution.maxProfit(prices1)); // Output: 3

        int[] prices2 = {1};
        System.out.println(solution.maxProfit(prices2)); // Output: 0

        int[] prices3 = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(prices3)); // Output: 5
    }
}
