class MinimumASCIIDeleteSumForTwoStrings:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        m, n = len(s1), len(s2)
        dp = [[0] * (n + 1) for _ in range(m + 1)]

        for i in range(1, m + 1):
            dp[i][0] = dp[i - 1][0] + ord(s1[i - 1])

        for j in range(1, n + 1):
            dp[0][j] = dp[0][j - 1] + ord(s2[j - 1])

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if s1[i - 1] == s2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = min(
                        dp[i - 1][j] + ord(s1[i - 1]), dp[i][j - 1] + ord(s2[j - 1])
                    )

        return dp[m][n]


# Time Complexity: O(m * n), where m and n are the lengths of the two strings.
# Space Complexity: O(m * n) for the dp table.

if __name__ == "__main__":
    solution = MinimumASCIIDeleteSumForTwoStrings()

    print("Expected Output: 231")
    print("Actual Output:", solution.minimumDeleteSum("sea", "eat"))

    print("Expected Output: 403")
    print("Actual Output:", solution.minimumDeleteSum("delete", "leet"))

    print("Expected Output: 0")
    print("Actual Output:", solution.minimumDeleteSum("", ""))
