class FindPivotIndex:
    def pivotIndex(self, nums: list[int]) -> int:
        s = sum(nums)
        cur = 0

        for i, n in enumerate(nums):
            if cur == s - cur - n:
                return i
            cur += n

        return -1

    # Time Complexity: O(n), where n is the length of nums
    # Space Complexity: O(1)

    def pivotIndexByArray(self, nums: list[int]) -> int:
        n = len(nums)
        left = [0] * n
        right = [0] * n
        left[0] = nums[0]
        right[n - 1] = nums[n - 1]

        for i in range(1, n):
            left[i] = left[i - 1] + nums[i]

        for i in range(n - 2, -1, -1):
            right[i] = right[i + 1] + nums[i]

        for i in range(n):
            if left[i] == right[i]:
                return i

        return -1

    # Time Complexity: O(n), where n is the length of nums
    # Space Complexity: O(n), where n is the length of nums


if __name__ == "__main__":
    sol = FindPivotIndex()

    print("Expected Output: 3")
    print("Actual Output:", sol.pivotIndex([1, 7, 3, 6, 5, 6]))
    print("Actual Output:", sol.pivotIndexByArray([1, 7, 3, 6, 5, 6]))

    print("Expected Output: -1")
    print("Actual Output:", sol.pivotIndex([1, 2, 3]))
    print("Actual Output:", sol.pivotIndexByArray([1, 2, 3]))

    print("Expected Output: 0")
    print("Actual Output:", sol.pivotIndex([2, 1, -1]))
    print("Actual Output:", sol.pivotIndexByArray([2, 1, -1]))
