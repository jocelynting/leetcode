class LongestPalindromicSubsequence:
    def longestPalindromeSubseq(self, s: str) -> int:
        n = len(s)
        dp = [[0] * n for _ in range(n)]

        for i in range(n):
            dp[i][i] = 1

        for length in range(2, n + 1):
            for i in range(n - length + 1):
                j = i + length - 1
                if s[i] == s[j]:
                    dp[i][j] = dp[i + 1][j - 1] + 2
                else:
                    dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])

        return dp[0][n - 1]


# Time Complexity: O(n^2), where n is the length of the string.
# Space Complexity: O(n^2) for the dp table.

if __name__ == "__main__":
    solution = LongestPalindromicSubsequence()

    print("Expected Output: 4")
    print("Actual Output:", solution.longestPalindromeSubseq("bbbab"))

    print("Expected Output: 2")
    print("Actual Output:", solution.longestPalindromeSubseq("cbbd"))

    print("Expected Output: 1")
    print("Actual Output:", solution.longestPalindromeSubseq("a"))
