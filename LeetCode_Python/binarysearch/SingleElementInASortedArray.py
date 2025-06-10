class SingleElementInASortedArray:
    def singleNonDuplicate(self, nums: list[int]) -> int:
        left, right = 0, len(nums) - 1

        while left < right:
            mid = left + (right - left) // 2

            if mid % 2 == 1:
                mid -= 1

            if nums[mid] == nums[mid + 1]:
                left = mid + 2
            else:
                right = mid

        return nums[left]


# Time Complexity: O(log n), where n is the number of elements in the input list.
# Space Complexity: O(1), as we are using a constant amount of space for variables.

if __name__ == "__main__":
    solution = SingleElementInASortedArray()

    print("Expected Output: 3")
    print("Actual Output:", solution.singleNonDuplicate([1, 1, 2, 2, 3, 4, 4]))

    print("Expected Output: 7")
    print(
        "Actual Output:",
        solution.singleNonDuplicate([1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7]),
    )

    print("Expected Output: 1")
    print("Actual Output:", solution.singleNonDuplicate([1, 2, 2, 3, 3]))
