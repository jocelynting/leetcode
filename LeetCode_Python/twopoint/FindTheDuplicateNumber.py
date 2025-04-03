class FindTheDuplicateNumber:
    def findDuplicate(self, nums: list[int]) -> int:
        """
        0 -> 1 -> 3 -> 2 -> 4
                       ↑    |
                       |    |
                       +----+
        """
        slow = nums[0]
        fast = nums[0]

        while True:
            slow = nums[slow]
            fast = nums[nums[fast]]
            if slow == fast:
                break

        slow = nums[0]
        while slow != fast:
            slow = nums[slow]
            fast = nums[fast]

        return slow


# Time Complexity: O(n)
# Space Complexity: O(1)


if __name__ == "__main__":
    sol = FindTheDuplicateNumber()

    print("Expected Output: 2")
    print("Actual Output:", sol.findDuplicate([1, 3, 4, 2, 2]))

    print("Expected Output: 3")
    print("Actual Output:", sol.findDuplicate([3, 1, 3, 4, 2]))

    print("Expected Output: 1")
    print("Actual Output:", sol.findDuplicate([1, 1]))
