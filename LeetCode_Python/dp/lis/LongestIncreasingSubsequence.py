class LongestIncreasingSubsequence:
    def lengthOfLIS(self, nums: list[int]) -> int:
        n = len(nums)
        dp = [1] * n
        res = 1

        for i in range(1, n):
            for j in range(i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i], dp[j] + 1)
                    res = max(res, dp[i])

        return res


if __name__ == "__main__":
    solution = LongestIncreasingSubsequence()

    print("Expected Output : 4")
    print("Actual Output : ", solution.lengthOfLIS([10, 9, 2, 5, 3, 7, 101, 18]))

    print("Expected Output : 4")
    print("Actual Output : ", solution.lengthOfLIS([0, 1, 0, 3, 2, 3]))

    print("Expected Output : 1")
    print("Actual Output : ", solution.lengthOfLIS([7, 7, 7, 7, 7, 7, 7]))
