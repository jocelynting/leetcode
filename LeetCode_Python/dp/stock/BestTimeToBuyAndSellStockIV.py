class BestTimeToBuyAndSellStockIV:
    def maxProfit(self, k: int, prices: list[int]) -> int:
        n = len(prices)

        if k >= n // 2:
            profit = 0
            for i in range(1, n):
                if prices[i] > prices[i - 1]:
                    profit += prices[i] - prices[i - 1]
            return profit

        total = 2 * k + 1
        dp = [[0] * total for _ in range(n)]

        for j in range(1, total):
            if j % 2 == 1:
                dp[0][j] = -prices[0]

        for i in range(1, n):
            for j in range(1, total):
                if j % 2 == 0:
                    dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i])
                else:
                    dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i])

        return max(dp[-1][j] for j in range(0, total, 2))


# Time Complexity: O(n * k), where n is the number of prices and k is the number of transactions
# Space Complexity: O(n * k), for the dp array

if __name__ == "__main__":
    solution = BestTimeToBuyAndSellStockIV()

    print("Expected Output: 2")
    print("Actual Output:", solution.maxProfit(2, [2, 4, 1]))

    print("Expected Output: 7")
    print("Actual Output:", solution.maxProfit(2, [3, 2, 6, 5, 0, 3]))

    print("Expected Output: 0")
    print("Actual Output:", solution.maxProfit(0, [1, 2, 3]))
