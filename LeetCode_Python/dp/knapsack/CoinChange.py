class CoinChange:
    def coinChange(self, coins: list[int], amount: int) -> int:
        dp = [amount + 1] * (amount + 1)
        dp[0] = 0

        for i in range(1, amount + 1):
            for coin in coins:
                if i >= coin:
                    dp[i] = min(dp[i], dp[i - coin] + 1)

        return dp[amount] if dp[amount] != amount + 1 else -1


# Time Complexity: O(n * m) where n is the amount and m is the number of coins
# Space Complexity: O(n) where n is the amount


if __name__ == "__main__":
    solution = CoinChange()

    print("Excepted Output: 3")
    print("Actual Output: ", solution.coinChange([1, 2, 5], 11))

    print("Excepted Output: -1")
    print("Actual Output: ", solution.coinChange([2], 3))
