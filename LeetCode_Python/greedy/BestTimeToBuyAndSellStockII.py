class BestTimeToBuyAndSellStockII:
    def maxProfit(self, prices: list[int]) -> int:
        n = len(prices)

        profit = 0
        for i in range(1, n):
            if prices[i] > prices[i - 1]:
                profit += prices[i] - prices[i - 1]
        return profit


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
