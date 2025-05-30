class HouseRobber:
    def rob(self, nums: list[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]

        dp = [0] * n
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        for i in range(2, n):
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])

        return dp[-1]

    # Time Complexity: O(n), where n is the number of houses
    # Space Complexity: O(n), for the dp array

    def rob_optimized(self, nums: list[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]

        first = nums[0]
        second = max(nums[0], nums[1])

        for i in range(2, n):
            temp = max(second, first + nums[i])
            first = second
            second = temp

        return second

    # Time Complexity: O(n), where n is the number of houses
    # Space Complexity: O(1), using only two variables to store previous states


if __name__ == "__main__":
    solution = HouseRobber()
    nums1 = [1, 2, 3, 1]
    print("Expected Output: 4")
    print("Actual Output:", solution.rob(nums1))
    print("Actual Output:", solution.rob_optimized(nums1))

    nums2 = [2, 7, 9, 3, 1]
    print("Expected Output: 12")
    print("Actual Output:", solution.rob(nums2))
    print("Actual Output:", solution.rob_optimized(nums2))

    nums3 = [10]
    print("Expected Output: 10")
    print("Actual Output:", solution.rob(nums3))
    print("Actual Output:", solution.rob_optimized(nums3))
