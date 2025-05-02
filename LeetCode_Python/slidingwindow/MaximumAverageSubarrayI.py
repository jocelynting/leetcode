class MaximumAverageSubarrayI:
    def findMaxAverage(self, nums: list[int], k: int) -> float:
        max_sum = sum(nums[:k])
        res = max_sum / k

        for i in range(k, len(nums)):
            max_sum += nums[i] - nums[i - k]
            res = max(res, max_sum / k)

        return res


# Time complexity: O(n), where n is the length of the nums list.
# Space complexity: O(1), as we are using a constant amount of space.

if __name__ == "__main__":
    solution = MaximumAverageSubarrayI()

    print("Expected Output: 12.75")
    print("Actual Output:", solution.findMaxAverage([1, 12, -5, -6, 50, 3], 4))

    print("Expected Output: 5.0")
    print("Actual Output:", solution.findMaxAverage([5], 1))
