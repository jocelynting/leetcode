class BinarySearch:
    def search(self, nums: list[int], target: int) -> int:
        left, right = 0, len(nums)

        while left < right:
            mid = left + (right - left) // 2
            if nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid
            else:
                return mid

        return -1


# Time Complexity: O(log n), where n is the number of elements in the list.
# Space Complexity: O(1), as we are using a constant amount of space.

if __name__ == "__main__":
    solution = BinarySearch()

    print("Expected Output: 4")
    print("Actual Output:", solution.search([-1, 0, 3, 5, 9, 12], 9))

    print("Expected Output: -1")
    print("Actual Output:", solution.search([-1, 0, 3, 5, 9, 12], 2))
