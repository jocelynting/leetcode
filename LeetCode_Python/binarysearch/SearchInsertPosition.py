class SearchInsertPosition:
    def searchInsert(self, nums: list[int], target: int) -> int:
        n = len(nums)
        left, right = 0, n

        while left < right:
            mid = left + (right - left) // 2
            if nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid
            else:
                return mid

        return left


# Time Complexity: O(log(n))
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = SearchInsertPosition()

    nums1 = [1, 3, 5, 6]
    target1 = 5
    print("Expected Output: 2")
    print("Actual Output:", solution.searchInsert(nums1, target1))

    nums2 = [1, 3, 5, 6]
    target2 = 2
    print("Expected Output: 1")
    print("Actual Output:", solution.searchInsert(nums2, target2))

    nums3 = [1, 3, 5, 6]
    target3 = 7
    print("Expected Output: 4")
    print("Actual Output:", solution.searchInsert(nums3, target3))
