class BestTimeToBuyAndSellStock:
    def maxProfit(self, prices: list[int]) -> int:
        min_price = float('inf')
        max_profit = 0
        for price in prices:
            min_price = min(min_price, price)
            max_profit = max(max_profit, price - min_price)
        return max_profit


if __name__ == '__main__':
    solution = BestTimeToBuyAndSellStock()
    prices1 = [7, 1, 5, 3, 6, 4]

    print("Expected Output:", 5)
    print("Actual Output:", solution.maxProfit(prices1))

    prices2 = [7, 6, 4, 3, 1]
    print("Expected Output:", 0)
    print("Actual Output:", solution.maxProfit(prices2))
