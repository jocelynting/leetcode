class PartitionEqualSubsetSum:
    def canPartition(self, nums: list[int]) -> bool:
        total = sum(nums)
        if total % 2 != 0:
            return False

        target = total // 2
        n = len(nums)
        dp = [False] * (target + 1)
        dp[0] = True

        for num in nums:
            for j in range(target, num - 1, -1):
                dp[j] = dp[j] or dp[j - num]

        return dp[target]


# Time Complexity: O(n * target), where n is the number of elements in the input list and target is half of the total sum.
# Space Complexity: O(target), where target is half of the total sum.

if __name__ == "__main__":
    solution = PartitionEqualSubsetSum()

    print("Expected Output: True")
    print("Actual Output:", solution.canPartition([1, 5, 11, 5]))

    print("Expected Output: False")
    print("Actual Output:", solution.canPartition([1, 2, 3, 5]))
