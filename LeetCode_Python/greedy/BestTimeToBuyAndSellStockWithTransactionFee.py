class BestTimeToBuyAndSellStockWithTransactionFee:
    def maxProfit(self, prices: list[int], fee: int) -> int:
        profit, hold = 0, -prices[0]

        for price in prices[1:]:
            profit = max(profit, hold + price - fee)
            hold = max(hold, profit - price)

        return profit


# Time Complexity: O(n), where n is the number of prices.
# Space Complexity: O(1), as we are using only a constant amount of space.

if __name__ == "__main__":
    solution = BestTimeToBuyAndSellStockWithTransactionFee()

    print("Expected Output: 8")
    print("Actual Output:", solution.maxProfit([1, 3, 2, 8, 4, 9], 2))

    print("Expected Output: 2")
    print("Actual Output:", solution.maxProfit([1, 2, 3, 4, 5], 2))

    print("Expected Output: 3")
    print("Actual Output:", solution.maxProfit([7, 1, 5, 3, 6, 4], 2))
