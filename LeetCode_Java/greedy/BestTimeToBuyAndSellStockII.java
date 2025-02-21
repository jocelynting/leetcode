package greedy;
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {

        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            int cur = prices[i] - prices[i - 1];
            if (cur > 0) {
                profit += cur;
            }
        }

        return profit;

    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII solution = new BestTimeToBuyAndSellStockII();

        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(prices)); // Output: 7
    }
}
