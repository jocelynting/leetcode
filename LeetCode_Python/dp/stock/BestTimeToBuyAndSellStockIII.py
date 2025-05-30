class BestTimeToBuyAndSellStockIII:
    def maxProfit(self, prices: list[int]) -> int:
        n = len(prices)
        dp = [[0] * 5 for _ in range(n)]

        dp[0][0] = 0
        dp[0][1] = -prices[0]
        dp[0][2] = 0
        dp[0][3] = -prices[0]
        dp[0][4] = 0

        for i in range(1, n):
            dp[i][0] = dp[i - 1][0]
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])
            dp[i][2] = max(dp[i - 1][2], dp[i - 1][1] + prices[i])
            dp[i][3] = max(dp[i - 1][3], dp[i - 1][2] - prices[i])
            dp[i][4] = max(dp[i - 1][4], dp[i - 1][3] + prices[i])

        return dp[n - 1][4]

    # Time Complexity: O(n), where n is the number of prices
    # Space Complexity: O(n), for the dp array

    def maxProfitOptimized(self, prices: list[int]) -> int:
        s0 = 0
        s1 = -prices[0]
        s2 = 0
        s3 = -prices[0]
        s4 = 0

        for price in prices[1:]:
            s0 = 0
            s1 = max(s1, s0 - price)
            s2 = max(s2, s1 + price)
            s3 = max(s3, s2 - price)
            s4 = max(s4, s3 + price)

        return s4

    # Time Complexity: O(n), where n is the number of prices
    # Space Complexity: O(1), using only a constant amount of space for variables


if __name__ == "__main__":
    solution = BestTimeToBuyAndSellStockIII()

    prices1 = [3, 3, 5, 0, 0, 3, 1, 4]
    print("Expected Output:", 6)
    print("Actual Output:", solution.maxProfit(prices1))
    print("Actual Output:", solution.maxProfitOptimized(prices1))

    prices2 = [1, 2, 3, 4, 5]
    print("Expected Output:", 4)
    print("Actual Output:", solution.maxProfit(prices2))
    print("Actual Output:", solution.maxProfitOptimized(prices2))

    prices3 = [7, 6, 4, 3, 1]
    print("Expected Output:", 0)
    print("Actual Output:", solution.maxProfit(prices3))
    print("Actual Output:", solution.maxProfitOptimized(prices3))
