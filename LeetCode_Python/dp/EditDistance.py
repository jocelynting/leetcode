class EditDistance:
    def minDistance(self, word1: str, word2: str) -> int:
        m, n = len(word1), len(word2)

        dp = [[0] * (n + 1) for _ in range(m + 1)]

        for i in range(m + 1):
            dp[i][0] = i
        for j in range(n + 1):
            dp[0][j] = j

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if word1[i - 1] == word2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1

        return dp[m][n]


# Time Complexity: O(m * n), where m is the length of word1 and n is the length of word2.
# Space Complexity: O(m * n), for the dp array used to store the edit distances.


if __name__ == "__main__":
    solution = EditDistance()

    word1 = "horse"
    word2 = "ros"
    print("Expected Output : 3")
    print("Actual Output : ", solution.minDistance(word1, word2))

    word1 = "intention"
    word2 = "execution"
    print("Expected Output : 5")
    print("Actual Output : ", solution.minDistance(word1, word2))
