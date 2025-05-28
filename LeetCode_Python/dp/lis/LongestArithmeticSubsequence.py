from collections import defaultdict


class LongestArithmeticSubsequence:
    def longestArithSeqLength(self, nums: list[int]) -> int:
        n = len(nums)
        dp = [defaultdict(int) for _ in range(n)]
        max_len = 0

        for i in range(n):
            for j in range(i):
                diff = nums[i] - nums[j]
                dp[i][diff] = max(dp[i][diff], dp[j][diff] + 1)
                max_len = max(max_len, dp[i][diff])

        return max_len + 1  # +1 to include the current element itself


# Time Complexity: O(n^2), where n is the length of the input array
# Space Complexity: O(n * d), where d is the number of unique differences

if __name__ == "__main__":
    solution = LongestArithmeticSubsequence()

    nums1 = [3, 6, 9, 12]
    print("Expected Output: 4")
    print("Actual Output:", solution.longestArithSeqLength(nums1))

    nums2 = [9, 4, 7, 2, 10]
    print("Expected Output: 3")
    print("Actual Output:", solution.longestArithSeqLength(nums2))

    nums3 = [20, 1, 15, 3, 10, 5]
    print("Expected Output: 4")
    print("Actual Output:", solution.longestArithSeqLength(nums3))
