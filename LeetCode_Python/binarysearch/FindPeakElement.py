class FindPeakElement:
    def findPeakElement(self, nums: list[int]) -> int:
        left, right = 0, len(nums) - 1

        while left < right:
            mid = (left + right) // 2
            if nums[mid] > nums[mid + 1]:
                right = mid
            else:
                left = mid + 1

        return left


# Time Complexity: O(log n), where n is the length of the input list.
# Space Complexity: O(1), as we are using a constant amount of space

if __name__ == "__main__":
    solution = FindPeakElement()

    print("Expected Output: 2")
    print("Actual Output:", solution.findPeakElement([1, 2, 3, 1]))

    print("Expected Output: 5")
    print("Actual Output:", solution.findPeakElement([1, 2, 1, 3, 5, 6, 4]))

    print("Expected Output: 6")
    print("Actual Output:", solution.findPeakElement([1, 2, 3, 4, 5, 6, 7]))
