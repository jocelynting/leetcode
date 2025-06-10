import bisect


class NumberOfSubsequencesThatSatisfyTheGivenSumCondition:
    def numSubseq(self, nums: list[int], target: int) -> int:
        nums.sort()
        n = len(nums)
        mod = 10**9 + 7
        res = 0

        for i in range(n):
            t = target - nums[i]
            index = bisect.bisect_right(nums, t) - 1
            if index >= i:
                res += pow(2, index - i, mod)
                res %= mod

        return res


# Time Complexity: O(n log n), where n is the length of nums due to sorting and binary search.
# Space Complexity: O(1), as we are using a constant amount of space for variables.

if __name__ == "__main__":
    solution = NumberOfSubsequencesThatSatisfyTheGivenSumCondition()

    print("Expected Output: 4")
    print("Actual Output:", solution.numSubseq([3, 5, 6, 7], 9))

    print("Expected Output: 6")
    print("Actual Output:", solution.numSubseq([3, 3, 6, 8], 10))

    print("Expected Output: 0")
    print("Actual Output:", solution.numSubseq([2, 3, 4, 5], 1))
