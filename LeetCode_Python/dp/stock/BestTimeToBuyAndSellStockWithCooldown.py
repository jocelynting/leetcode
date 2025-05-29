class BestTimeToBuyAndSellStockWithCooldown:
    def maxProfit(self, prices: list[int]) -> int:
        n = len(prices)

        hold = [0] * n
        sold = [0] * n
        cooldown = [0] * n

        hold[0] = -prices[0]
        sold[0] = 0
        cooldown[0] = 0

        for i in range(1, n):
            hold[i] = max(hold[i - 1], cooldown[i - 1] - prices[i])
            sold[i] = hold[i - 1] + prices[i]
            cooldown[i] = max(cooldown[i - 1], sold[i - 1])

        return max(sold[-1], cooldown[-1])

    # Time Complexity: O(n), where n is the number of days
    # Space Complexity: O(n), for the hold, sold, and cooldown arrays

    def maxProfitOptimized(self, prices: list[int]) -> int:
        hold = -prices[0]
        sold = 0
        cooldown = 0

        for p in prices[1:]:
            prev_sold = sold
            sold = hold + p
            hold = max(hold, cooldown - p)
            cooldown = max(cooldown, prev_sold)

        return max(sold, cooldown)

    # Time Complexity: O(n), where n is the number of days
    # Space Complexity: O(1), using only a few variables


if __name__ == "__main__":
    solution = BestTimeToBuyAndSellStockWithCooldown()

    prices1 = [1, 2, 3, 0, 2]
    print("Expected Output: 3")
    print("Actual Output:", solution.maxProfit(prices1))
    print("Actual Output:", solution.maxProfitOptimized(prices1))

    prices2 = [1]
    print("Expected Output: 0")
    print("Actual Output:", solution.maxProfit(prices2))
    print("Actual Output:", solution.maxProfitOptimized(prices2))

    prices3 = [7, 1, 5, 3, 6, 4]
    print("Expected Output: 5")
    print("Actual Output:", solution.maxProfit(prices3))
    print("Actual Output:", solution.maxProfitOptimized(prices3))
