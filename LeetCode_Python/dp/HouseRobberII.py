class HouseRobberII:
    def rob(self, nums: list[int]) -> int:
        def rob_linear(arr: list[int]) -> int:
            n = len(arr)
            if n == 0:
                return 0
            if n == 1:
                return arr[0]
            dp = [0] * n
            dp[0] = arr[0]
            dp[1] = max(arr[0], arr[1])
            for i in range(2, n):
                dp[i] = max(dp[i - 1], dp[i - 2] + arr[i])
            return dp[-1]

        n = len(nums)
        if n == 1:
            return nums[0]

        rob1 = rob_linear(nums[:-1])
        rob2 = rob_linear(nums[1:])

        return max(rob1, rob2)


# Time Complexity: O(n)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = HouseRobberII()

    print("Expected Output: 3")
    print("Actual Output:", solution.rob([2, 3, 2]))

    print("Expected Output: 4")
    print("Actual Output:", solution.rob([1, 2, 3, 1]))
