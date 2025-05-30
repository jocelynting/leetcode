class OnesAndZeroes:
    def findMaxForm(self, strs: list[str], m: int, n: int) -> int:
        dp = [[0] * (n + 1) for _ in range(m + 1)]

        for s in strs:
            zeros = s.count("0")
            ones = s.count("1")

            for i in range(m, zeros - 1, -1):
                for j in range(n, ones - 1, -1):
                    dp[i][j] = max(dp[i][j], dp[i - zeros][j - ones] + 1)

        return dp[m][n]


# Time Complexity: O(L * m * n), where L is the number of strings, m is the maximum number of 0s, and n is the maximum number of 1s
# Space Complexity: O(m * n), for the dp array

if __name__ == "__main__":
    solution = OnesAndZeroes()

    print("Expected Output: 4")
    print(
        "Actual Output:", solution.findMaxForm(["10", "0001", "111001", "1", "0"], 5, 3)
    )

    print("Expected Output: 2")
    print("Actual Output:", solution.findMaxForm(["10", "0", "1"], 1, 1))
