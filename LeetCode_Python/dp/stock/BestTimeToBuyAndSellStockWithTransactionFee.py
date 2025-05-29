class BestTimeToBuyAndSellStockWithTransactionFee:
    def maxProfit(self, prices: list[int], fee: int) -> int:
        n = len(prices)
        dp = [[0] * 2 for _ in range(n)]

        dp[0][0] = 0
        dp[0][1] = -prices[0]

        for i in range(1, n):
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee)
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])

        return dp[n - 1][0]

    # Time Complexity: O(n), where n is the number of prices.
    # Space Complexity: O(n), for the dp array.

    def maxProfitOptimized(self, prices: list[int], fee: int) -> int:
        hold = -prices[0]
        sold = 0

        for price in prices[1:]:
            prev_hold = hold
            hold = max(hold, sold - price)
            sold = max(sold, prev_hold + price - fee)

        return sold

    # Time Complexity: O(n), where n is the number of prices.
    # Space Complexity: O(1), using only a few variables.


if __name__ == "__main__":
    solution = BestTimeToBuyAndSellStockWithTransactionFee()

    print("Expected Output: 8")
    print("Actual Output:", solution.maxProfit([1, 3, 2, 8, 4, 9], 2))
    print("Actual Output:", solution.maxProfitOptimized([1, 3, 2, 8, 4, 9], 2))

    print("Expected Output: 2")
    print("Actual Output:", solution.maxProfit([1, 2, 3, 4, 5], 2))
    print("Actual Output:", solution.maxProfitOptimized([1, 2, 3, 4, 5], 2))

    print("Expected Output: 3")
    print("Actual Output:", solution.maxProfit([7, 1, 5, 3, 6, 4], 2))
    print("Actual Output:", solution.maxProfitOptimized([7, 1, 5, 3, 6, 4], 2))
