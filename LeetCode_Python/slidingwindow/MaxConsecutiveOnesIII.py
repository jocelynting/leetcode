class MaxConsecutiveOnesIII:
    def longestOnes(self, nums: list[int], k: int) -> int:
        n = len(nums)
        left = 0
        max_length = 0
        for right in range(n):
            if nums[right] == 0:
                k -= 1
            while k < 0:
                if nums[left] == 0:
                    k += 1
                left += 1
            max_length = max(max_length, right - left + 1)
        return max_length


# Time Complexity: O(n), where n is the length of the input list nums.
# Space Complexity: O(1), as we are using only a constant amount of space.

if __name__ == "__main__":
    solution = MaxConsecutiveOnesIII()

    print("Expected Output: 6")
    print("Actual Output:", solution.longestOnes([1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0], 2))

    print("Expected Output: 10")
    print(
        "Actual Output:",
        solution.longestOnes(
            [0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1], 3
        ),
    )
