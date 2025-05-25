class DistinctSubsequences:
    def numDistinct(self, s: str, t: str) -> int:
        m, n = len(s), len(t)
        dp = [[0] * (n + 1) for _ in range(m + 1)]

        for i in range(m + 1):
            dp[i][0] = 1  # An empty t can be formed from any prefix of s

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if s[i - 1] == t[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j]

        return dp[m][n]


# Time Complexity: O(m * n), where m is the length of s and n is the length of t.
# Space Complexity: O(m * n) for the dp array.

if __name__ == "__main__":
    solution = DistinctSubsequences()

    print("Expected Output: 3")
    print("Actual Output:", solution.numDistinct("rabbbit", "rabbit"))

    print("Expected Output: 5")
    print("Actual Output:", solution.numDistinct("babgbag", "bag"))

    print("Expected Output: 0")
    print("Actual Output:", solution.numDistinct("abc", "def"))
