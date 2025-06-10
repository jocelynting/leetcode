class ValidTriangleNumber:
    def triangleNumber(self, nums: list[int]) -> int:
        n = len(nums)
        if n < 3:
            return 0

        nums.sort()
        res = 0

        for i in range(2, n):
            left, right = 0, i - 1

            while left < right:
                if nums[left] + nums[right] > nums[i]:
                    res += right - left
                    right -= 1
                else:
                    left += 1

        return res


# Time Complexity: O(n^2), where n is the number of elements in nums.
# Space Complexity: O(1) for the result variable and O(n) for sorting the input list.

if __name__ == "__main__":
    solution = ValidTriangleNumber()

    nums = [2, 2, 3, 4]
    print("Expected Output: 3")
    print("Actual Output:", solution.triangleNumber(nums))

    nums = [4, 2, 3, 4]
    print("Expected Output: 4")
    print("Actual Output:", solution.triangleNumber(nums))

    nums = [0, 1, 1]
    print("Expected Output: 0")
    print("Actual Output:", solution.triangleNumber(nums))
