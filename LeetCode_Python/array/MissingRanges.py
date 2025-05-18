class MissingRanges:
    def findMissingRanges(
        self, nums: list[int], lower: int, upper: int
    ) -> list[list[int]]:
        n = len(nums)
        res = []
        pre = lower - 1

        for i in range(n + 1):
            cur = nums[i] if i < n else upper + 1

            if cur - pre >= 2:
                res.append([pre + 1, cur - 1])

            pre = cur

        return res


# Time Complexity: O(n), where n is the length of the nums list.
# Space Complexity: O(1), since we are using a fixed amount of space for the variables.

if __name__ == "__main__":
    solution = MissingRanges()

    print("Expected Output: [[2, 2], [4, 49], [51, 74], [76, 99]]")
    print("Actual Output:", solution.findMissingRanges([0, 1, 3, 50, 75], 0, 99))

    print("Expected Output: []")
    print("Actual Output:", solution.findMissingRanges([-1], -1, -1))
