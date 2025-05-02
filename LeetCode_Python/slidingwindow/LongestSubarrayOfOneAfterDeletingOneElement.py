class LongestSubarrayOfOneAfterDeletingOneElement:
    def longestSubarray(self, nums: list[int]) -> int:
        n = len(nums)
        left = right = 0
        res = 0
        count = 0

        while right < n:
            if nums[right] == 0:
                count += 1

            while count > 1:
                if nums[left] == 0:
                    count -= 1
                left += 1

            res = max(res, right - left)
            right += 1

        return res


# Time Complexity: O(n), where n is the length of the input list nums.
# Space Complexity: O(1), since we are using a constant amount of space.

if __name__ == "__main__":
    solution = LongestSubarrayOfOneAfterDeletingOneElement()

    print("Expected Output: 3")
    print("Actual Output:", solution.longestSubarray([1, 1, 0, 1]))

    print("Expected Output: 5")
    print("Actual Output:", solution.longestSubarray([0, 1, 1, 1, 0, 1, 1, 0, 1]))

    print("Expected Output: 2")
    print("Actual Output:", solution.longestSubarray([1, 1, 1]))
