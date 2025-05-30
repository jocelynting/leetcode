class PerfectSquares:
    def numSquares(self, n: int) -> int:
        dp = [float("inf")] * (n + 1)
        dp[0] = 0
        squares = [i * i for i in range(1, int(n**0.5) + 1)]

        for s in squares:
            for i in range(s, n + 1):
                dp[i] = min(dp[i], dp[i - s] + 1)

        return dp[n]


# Time Complexity: O(n * sqrt(n)), where n is the target number
# Space Complexity: O(n), for the dp array

if __name__ == "__main__":
    solution = PerfectSquares()

    print("Expected Output: 3")
    print("Actual Output:", solution.numSquares(12))

    print("Expected Output: 2")
    print("Actual Output:", solution.numSquares(13))
