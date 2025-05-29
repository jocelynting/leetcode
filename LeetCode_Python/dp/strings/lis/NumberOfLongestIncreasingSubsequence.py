class NumberOfLongestIncreasingSubsequence:
    def findNumberOfLIS(self, nums: list[int]) -> int:
        n = len(nums)

        length = [1] * n
        count = [1] * n

        for i in range(n):
            for j in range(i):
                if nums[i] > nums[j]:
                    if length[j] + 1 > length[i]:
                        length[i] = length[j] + 1
                        count[i] = count[j]
                    elif length[j] + 1 == length[i]:
                        count[i] += count[j]

        max_len = max(length)
        res = sum(c for i, c in enumerate(count) if length[i] == max_len)
        return res


# Time Complexity: O(n^2), where n is the length of the input list nums.
# Space Complexity: O(n), for the length and count arrays.

if __name__ == "__main__":
    solution = NumberOfLongestIncreasingSubsequence()

    print("Expected Output : 4")
    print("Actual Output : ", solution.findNumberOfLIS([10, 9, 2, 5, 3, 7, 101, 18]))

    print("Expected Output : 2")
    print("Actual Output : ", solution.findNumberOfLIS([1, 3, 5, 4, 7]))

    print("Expected Output : 5")
    print("Actual Output : ", solution.findNumberOfLIS([2, 2, 2, 2, 2]))
