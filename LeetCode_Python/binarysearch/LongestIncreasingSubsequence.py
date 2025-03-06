class LongestIncreasingSubsequence:
    def lengthOfLIS(self, nums: list[int]) -> int:
        res = []

        for num in nums:
            left, right = 0, len(res) - 1
            while left <= right:
                mid = (left + right) // 2
                if res[mid] < num:
                    left = mid + 1
                else:
                    right = mid - 1
            if left == len(res):
                res.append(num)
            else:
                res[left] = num

        return len(res)


if __name__ == "__main__":
    solution = LongestIncreasingSubsequence()

    print("Expected Output : 4")
    print("Actual Output : ", solution.lengthOfLIS([10, 9, 2, 5, 3, 7, 101, 18]))

    print("Expected Output : 4")
    print("Actual Output : ", solution.lengthOfLIS([0, 1, 0, 3, 2, 3]))

    print("Expected Output : 1")
    print("Actual Output : ", solution.lengthOfLIS([7, 7, 7, 7, 7, 7, 7]))
