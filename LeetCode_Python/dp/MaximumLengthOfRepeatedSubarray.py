class MaximumLengthOfRepeatedSubarray:
    def findLength(self, nums1: list[int], nums2: list[int]) -> int:
        m, n = len(nums1), len(nums2)
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        res = 0

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if nums1[i - 1] == nums2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1] + 1
                    res = max(res, dp[i][j])

        return res


# Time Complexity: O(m * n), where m and n are the lengths of nums1 and nums2 respectively.
# Space Complexity: O(m * n), for the dp array used to store lengths of common subarrays.

if __name__ == "__main__":
    solution = MaximumLengthOfRepeatedSubarray()

    nums1 = [1, 2, 3, 2, 1]
    nums2 = [3, 2, 1, 4, 7]
    print("Expected Output: 3")
    print("Actual Output:", solution.findLength(nums1, nums2))

    nums1 = [0, 0, 0, 0, 1]
    nums2 = [0, 0, 0, 1, 1]
    print("Expected Output: 4")
    print("Actual Output:", solution.findLength(nums1, nums2))
