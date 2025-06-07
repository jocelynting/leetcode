class FindMinimumInRotatedSortedArray:
    def findMin(self, nums):
        n = len(nums)
        left, right = 0, n

        while left < right:
            mid = left + (right - left) // 2

            if nums[mid] > nums[n - 1]:
                left = mid + 1
            else:
                right = mid

        return nums[left]


# Time Complexity: O(log n) due to binary search.
# Space Complexity: O(1) since we are using a constant amount of space.

if __name__ == "__main__":
    solution = FindMinimumInRotatedSortedArray()

    nums = [3, 4, 5, 1, 2]
    print("Expected Output: 1")
    print("Actual Output:", solution.findMin(nums))

    nums = [4, 5, 6, 7, 0, 1, 2]
    print("Expected Output: 0")
    print("Actual Output:", solution.findMin(nums))

    nums = [11, 13, 15, 17]
    print("Expected Output: 11")
    print("Actual Output:", solution.findMin(nums))
