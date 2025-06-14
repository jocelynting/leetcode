class FindMinimumInRotatedSortedArrayII:
    def findMin(self, nums: list[int]) -> int:
        n = len(nums)
        left, right = 0, n - 1

        while left < right:
            mid = left + (right - left) // 2
            if nums[mid] > nums[right]:
                left = mid + 1
            elif nums[mid] < nums[right]:
                right = mid
            else:
                right -= 1

        return nums[left]


# Time Complexity: O(log n) in the average case, but can degrade to O(n) in the worst case when all elements are equal.
# Space Complexity: O(1), we are using a constant amount of space.

if __name__ == "__main__":
    solution = FindMinimumInRotatedSortedArrayII()

    print("Expected Output: 1")
    print("Actual Output:", solution.findMin([1, 3, 5]))

    print("Expected Output: 0")
    print("Actual Output:", solution.findMin([2, 2, 2, 0, 1]))

    print("Expected Output: 1")
    print("Actual Output:", solution.findMin([3, 3, 1, 3]))
