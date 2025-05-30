class CoinChangeII:
    def change(self, amount: int, coins: list[int]) -> int:
        dp = [0] * (amount + 1)
        dp[0] = 1

        for coin in coins:
            for i in range(coin, amount + 1):
                dp[i] += dp[i - coin]

        return dp[amount]


# Time Complexity: O(n * m) where n is the number of coins and m is the amount
# Space Complexity: O(n) where n is the amount


if __name__ == "__main__":
    solution = CoinChangeII()

    print("Excepted Output: 4")
    print("Actual Output: ", solution.change(5, [1, 2, 5]))

    print("Excepted Output: 0")
    print("Actual Output: ", solution.change(3, [2]))

    print("Excepted Output: 1")
    print("Actual Output: ", solution.change(10, [10]))
