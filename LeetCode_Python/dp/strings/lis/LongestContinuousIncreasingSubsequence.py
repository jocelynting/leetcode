class LongestContinuousIncreasingSubsequence:
    def findLengthOfLCIS(self, nums: list[int]) -> int:
        n = len(nums)
        dp = [1] * n
        res = 1

        for i in range(1, n):
            if nums[i] > nums[i - 1]:
                dp[i] = dp[i - 1] + 1
            res = max(res, dp[i])

        return res


# Time Complexity: O(n), where n is the length of the input list.
# Space Complexity: O(n), for the dp array.

if __name__ == "__main__":
    solution = LongestContinuousIncreasingSubsequence()

    print("Expected Output : 3")
    print("Actual Output : ", solution.findLengthOfLCIS([1, 3, 5, 4, 7]))

    print("Expected Output : 1")
    print("Actual Output : ", solution.findLengthOfLCIS([2, 2, 2, 2, 2]))

    print("Expected Output : 1")
    print("Actual Output : ", solution.findLengthOfLCIS([1]))
