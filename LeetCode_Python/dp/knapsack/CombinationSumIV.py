class CombinationSumIV:
    def combinationSum4(self, nums, target):
        dp = [0] * (target + 1)
        dp[0] = 1

        for i in range(1, target + 1):
            for num in nums:
                if i - num >= 0:
                    dp[i] += dp[i - num]

        return dp[target]


# Time Complexity: O(n * target), where n is the length of nums and target is the target sum
# Space Complexity: O(target), for the dp array

if __name__ == "__main__":
    solution = CombinationSumIV()

    print("Expected Output: 7")
    print("Actual Output:", solution.combinationSum4([1, 2, 3], 4))

    print("Expected Output: 0")
    print("Actual Output:", solution.combinationSum4([9], 3))

    print("Expected Output: 1")
    print("Actual Output:", solution.combinationSum4([1], 1))
