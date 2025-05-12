class MonotonicArray:
    def isMonotonic(self, nums: list[int]) -> bool:
        increasing = decreasing = True

        for i in range(len(nums) - 1):
            if nums[i] > nums[i + 1]:
                increasing = False
            if nums[i] < nums[i + 1]:
                decreasing = False

        return increasing or decreasing


# Time Complexity: O(n), where n is the length of the nums list
# Space Complexity: O(1), since we are using a constant amount of space

if __name__ == "__main__":
    solution = MonotonicArray()

    print("Expected Output: True")
    print("Actual Output:", solution.isMonotonic([1, 2, 2, 3]))

    print("Expected Output: True")
    print("Actual Output:", solution.isMonotonic([6, 5, 4, 4]))

    print("Expected Output: False")
    print("Actual Output:", solution.isMonotonic([1, 3, 2]))
