class RemoveDuplicatesFromSortedArray:
    def removeDuplicates(self, nums: list[int]) -> int:
        n = len(nums)
        index = 1

        for i in range(1, n):
            if nums[i] != nums[i - 1]:
                nums[index] = nums[i]
                index += 1

        return index


# Time Complexity: O(n)
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = RemoveDuplicatesFromSortedArray()

    print("Expected Output: 2")
    print("Actual Output:", solution.removeDuplicates([1, 1, 2]))

    print("Expected Output: 5")
    print("Actual Output:", solution.removeDuplicates([0, 0, 1, 1, 2, 2, 3, 4]))
