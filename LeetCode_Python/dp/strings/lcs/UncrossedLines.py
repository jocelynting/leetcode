class UncrossedLines:
    def maxUncrossedLines(self, nums1: list[int], nums2: list[int]) -> int:
        m, n = len(nums1), len(nums2)
        dp = [[0] * (n + 1) for _ in range(m + 1)]

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if nums1[i - 1] == nums2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1] + 1
                else:
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

        return dp[m][n]


# Time Complexity: O(m * n), where m and n are the lengths of nums1 and nums2 respectively.
# Space Complexity: O(m * n), for the dp array.

if __name__ == "__main__":
    solution = UncrossedLines()

    print("Expected Output: 2")
    print("Actual Output:", solution.maxUncrossedLines([1, 4, 2], [1, 2, 4]))

    print("Expected Output: 3")
    print(
        "Actual Output:",
        solution.maxUncrossedLines([2, 5, 1, 2, 5], [10, 5, 2, 1, 5, 2]),
    )

    print("Expected Output: 0")
    print("Actual Output:", solution.maxUncrossedLines([1, 3], [2, 4]))
