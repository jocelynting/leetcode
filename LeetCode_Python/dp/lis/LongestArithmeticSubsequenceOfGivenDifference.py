class LongestArithmeticSubsequenceOfGivenDifference:
    def longestSubsequence(self, arr: list[int], difference: int) -> int:
        dp = {}
        max_len = 0

        for num in arr:
            dp[num] = dp.get(num - difference, 0) + 1
            max_len = max(max_len, dp[num])

        return max_len


# Time Complexity: O(n), where n is the length of the input array
# Space Complexity: O(n), for the dp dictionary

if __name__ == "__main__":
    solution = LongestArithmeticSubsequenceOfGivenDifference()

    arr1 = [1, 2, 3, 4]
    difference1 = 1
    print("Expected Output: 4")
    print("Actual Output:", solution.longestSubsequence(arr1, difference1))

    arr2 = [1, 3, 5, 7]
    difference2 = 2
    print("Expected Output: 4")
    print("Actual Output:", solution.longestSubsequence(arr2, difference2))

    arr3 = [1, 5, 7, 8]
    difference3 = -2
    print("Expected Output: 1")
    print("Actual Output:", solution.longestSubsequence(arr3, difference3))
