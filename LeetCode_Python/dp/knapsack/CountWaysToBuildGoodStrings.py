class CountWaysToBuildGoodStrings:
    def countGoodStrings(self, low: int, high: int, zero: int, one: int) -> int:
        mod = 10**9 + 7
        dp = [0] * (high + 1)
        dp[0] = 1

        for i in range(1, high + 1):
            if i >= zero:
                dp[i] = (dp[i] + dp[i - zero]) % mod
            if i >= one:
                dp[i] = (dp[i] + dp[i - one]) % mod

        return sum(dp[low : high + 1]) % mod


# Time Complexity: O(high), where high is the maximum length of the good strings
# Space Complexity: O(high), for the dp array

if __name__ == "__main__":
    solution = CountWaysToBuildGoodStrings()

    print("Expected Output: 8")
    print("Actual Output:", solution.countGoodStrings(3, 3, 1, 1))

    print("Expected Output: 5")
    print("Actual Output:", solution.countGoodStrings(2, 3, 1, 2))
