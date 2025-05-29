class LongestCommonSubsequence:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        m, n = len(text1), len(text2)
        dp = [[0] * (n + 1) for _ in range(m + 1)]

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if text1[i - 1] == text2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1] + 1
                else:
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

        return dp[m][n]


# Time Complexity: O(m * n), where m and n are the lengths of text1 and text2 respectively.
# Space Complexity: O(m * n), for the dp array.

if __name__ == "__main__":
    solution = LongestCommonSubsequence()

    print("Expected Output: 3")
    print("Actual Output:", solution.longestCommonSubsequence("abcde", "ace"))

    print("Expected Output: 0")
    print("Actual Output:", solution.longestCommonSubsequence("abc", "def"))

    print("Expected Output: 5")
    print("Actual Output:", solution.longestCommonSubsequence("abcde", "abcde"))
