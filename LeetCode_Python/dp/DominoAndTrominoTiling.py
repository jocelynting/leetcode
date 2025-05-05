class DominoAndTrominoTiling:
    def numTilings(self, n: int) -> int:
        if n == 0:
            return 1
        if n == 1:
            return 1
        if n == 2:
            return 2

        mod = 10**9 + 7
        dp = [0] * (n + 1)
        dp[0], dp[1], dp[2] = 1, 1, 2

        for i in range(3, n + 1):
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % mod

        return dp[n]


# Time Complexity: O(n), where n is the length of the dominoes string.
# Space Complexity: O(n), for the dp array.

if __name__ == "__main__":
    solution = DominoAndTrominoTiling()

    print("Expected Output: 5")
    print("Actual Output:", solution.numTilings(3))

    print("Expected Output: 1")
    print("Actual Output:", solution.numTilings(1))

    print("Expected Output: 11")
    print("Actual Output:", solution.numTilings(4))
