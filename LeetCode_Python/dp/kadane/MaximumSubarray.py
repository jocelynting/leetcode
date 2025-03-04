class MaximumSubarray:
    def maxSubArray(self, nums: list[int]) -> int:
        cur_sum = max_sum = nums[0]

        for n in nums[1:]:
            cur_sum = max(n, n + cur_sum)
            max_sum = max(max_sum, cur_sum)

        return max_sum


if __name__ == '__main__':
    solution = MaximumSubarray()

    nums1 = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    print("Expected Output:", 6)
    print("Actual Output:", solution.maxSubArray(nums1))

    nums2 = [1]
    print("Expected Output:", 1)
    print("Actual Output:", solution.maxSubArray(nums2))

    nums3 = [-3, -2, -1, -4]
    print("Expected Output:", -1)
    print("Actual Output:", solution.maxSubArray(nums3))
