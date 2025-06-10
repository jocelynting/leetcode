import bisect


class TwoSumLessThanK:
    def twoSumLessThanK(self, nums, k):
        nums.sort()
        res = -1
        n = len(nums)

        for i in range(n):
            target = k - nums[i]
            j = bisect.bisect_left(nums, target, i + 1, n) - 1
            if j > i:
                res = max(res, nums[i] + nums[j])

        return res


# Time Complexity: O(n log n) due to sorting and binary search
# Space Complexity: O(1) for the result variable, O(n) for the input list

if __name__ == "__main__":
    solution = TwoSumLessThanK()

    print("Expected Output: 58")
    print(
        "Actual Output:", solution.twoSumLessThanK([34, 23, 1, 24, 75, 33, 54, 8], 60)
    )

    print("Expected Output: -1")
    print("Actual Output:", solution.twoSumLessThanK([10, 20, 30], 15))
