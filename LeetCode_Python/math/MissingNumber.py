class MissingNumber:
    def missingNumber(self, nums: list[int]) -> int:
        n = len(nums)
        total = n * (n + 1) // 2

        for num in nums:
            total -= num
        return total


# Time Complexity: O(n)
# Space Complexity: O(1)


if __name__ == "__main__":
    solution = MissingNumber()

    print("Expected Output: 2")
    print("Actual Output:", solution.missingNumber([3, 0, 1]))

    print("Expected Output: 8")
    print("Actual Output:", solution.missingNumber([0, 1, 2, 3, 4, 5, 6, 7, 9]))
