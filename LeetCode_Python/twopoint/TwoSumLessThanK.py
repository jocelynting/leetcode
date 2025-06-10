class TwoSumLessThanK:
    def twoSumLessThanK(self, nums, k):
        nums.sort()
        res = -1
        n = len(nums)
        left, right = 0, n - 1

        while left < right:
            cur = nums[left] + nums[right]
            if cur < k:
                res = max(res, cur)
                left += 1
            else:
                right -= 1

        return res


# Time Complexity: O(n log n) due to sorting, O(n) for the two-pointer traversal
# Space Complexity: O(1) for the result variable, O(n) for the input list

if __name__ == "__main__":
    solution = TwoSumLessThanK()

    print("Expected Output: 58")
    print(
        "Actual Output:", solution.twoSumLessThanK([34, 23, 1, 24, 75, 33, 54, 8], 60)
    )

    print("Expected Output: -1")
    print("Actual Output:", solution.twoSumLessThanK([10, 20, 30], 15))
