class LongestConsecutiveSequence:
    def longestConsecutive(self, nums: list[int]) -> int:
        num_set = set(nums)
        res = 0

        for num in num_set:
            if num - 1 not in num_set:
                cur = num
                length = 1

                while cur + 1 in num_set:
                    cur += 1
                    length += 1

                res = max(res, length)

        return res


# Time Complexity: O(n)
# Space Complexity: O(n)


if __name__ == "__main__":
    solution = LongestConsecutiveSequence()

    print("Expected Output: 4")
    print("Actual Output:", solution.longestConsecutive([100, 4, 200, 1, 3, 2]))

    print("Expected Output: 9")
    print("Actual Output:", solution.longestConsecutive([0, 3, 7, 2, 5, 8, 4, 6, 0, 1]))
