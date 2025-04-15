class RemoveDuplicatesFromSortedArrayII:
    def removeDuplicates(self, nums: list[int]) -> int:
        n = len(nums)
        if n <= 2:
            return n

        slow = 2
        for fast in range(2, n):
            if nums[fast] != nums[slow - 2]:
                nums[slow] = nums[fast]
                slow += 1

        return slow


# Time Complexity: O(n), where n is the length of the input list nums.
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = RemoveDuplicatesFromSortedArrayII()

    print("Expected Output: 5")
    print("Actual Output:", solution.removeDuplicates([1, 1, 1, 2, 2, 3]))

    print("Expected Output: 7")
    print("Actual Output:", solution.removeDuplicates([0, 0, 1, 1, 1, 1, 2, 3, 3]))
