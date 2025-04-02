class BestTimeToBuyAndSellStockII:
    def maxProfit(self, prices: list[int]) -> int:
        n = len(prices)

        dp = [[0] * 2 for _ in range(n)]
        dp[0][0] = 0
        dp[0][1] = -prices[0]

        for i in range(1, n):
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])

        return dp[n - 1][0]


# Time Complexity: O(n)
# Space Complexity: O(n)


if __name__ == "__main__":
    solution = BestTimeToBuyAndSellStockII()

    prices1 = [7, 1, 5, 3, 6, 4]
    print("Expected Output:", 7)
    print("Actual Output:", solution.maxProfit(prices1))

    prices2 = [7, 6, 4, 3, 1]
    print("Expected Output:", 0)
    print("Actual Output:", solution.maxProfit(prices2))
