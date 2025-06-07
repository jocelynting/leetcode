class FindFirstAndLastPositionOfElementInSortedArray:
    def searchRange(self, nums: list[int], target: int) -> list[int]:
        def findIndex(start: bool) -> int:
            index = -1
            left, right = 0, len(nums)

            while left < right:
                mid = left + (right - left) // 2
                if nums[mid] < target:
                    left = mid + 1
                elif nums[mid] > target:
                    right = mid
                else:
                    index = mid
                    if start:
                        right = mid
                    else:
                        left = mid + 1

            return index

        start = findIndex(True)
        if start == -1:
            return [-1, -1]
        end = findIndex(False)
        return [start, end]


# Time Complexity: O(log n), where n is the length of the input list.
# Space Complexity: O(1), as we are using a constant amount of space for variables.

if __name__ == "__main__":
    solution = FindFirstAndLastPositionOfElementInSortedArray()

    print("Expected Output: [3, 4]")
    print("Actual Output:", solution.searchRange([5, 7, 7, 8, 8, 10], 8))

    print("Expected Output: [-1, -1]")
    print("Actual Output:", solution.searchRange([5, 7, 7, 8, 8, 10], 6))

    print("Expected Output: [0, 0]")
    print("Actual Output:", solution.searchRange([1], 1))
