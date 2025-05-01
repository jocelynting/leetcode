class MaxNumberOfKSumPairs:
    def maxOperations(self, nums: list[int], k: int) -> int:
        if len(nums) < 2:
            return 0

        nums.sort()
        left, right = 0, len(nums) - 1
        res = 0

        while left < right:
            s = nums[left] + nums[right]
            if s < k:
                left += 1
            elif s > k:
                right -= 1
            else:
                res += 1
                left += 1
                right -= 1

        return res


# Time Complexity: O(n log n), where n is the length of the input list
# Space Complexity: O(1), since we are using only a constant amount of space

if __name__ == "__main__":
    solution = MaxNumberOfKSumPairs()

    print("Expected Output: 2")
    print("Actual Output:", solution.maxOperations([1, 2, 3, 4], 5))

    print("Expected Output: 1")
    print("Actual Output:", solution.maxOperations([3, 1, 3, 4, 3], 6))

    print("Expected Output: 1")
    print("Actual Output:", solution.maxOperations([1, 2, 3, 4], 7))
