class MaximumLengthOfPairChain:
    def findLongestChain(self, pairs: list[list[int]]) -> int:
        n = len(pairs)
        pairs.sort()
        dp = [1] * n
        res = 1

        for i in range(1, n):
            for j in range(i):
                if pairs[j][1] < pairs[i][0]:
                    dp[i] = max(dp[i], dp[j] + 1)
                    res = max(res, dp[i])

        return res


# Time Complexity: O(n^2), where n is the number of pairs
# Space Complexity: O(n), for the dp array

if __name__ == "__main__":
    solution = MaximumLengthOfPairChain()

    print("Expected Output : 2")
    print("Actual Output : ", solution.findLongestChain([[1, 2], [2, 3], [3, 4]]))

    print("Expected Output : 3")
    print("Actual Output : ", solution.findLongestChain([[1, 2], [7, 8], [4, 5]]))

    print("Expected Output : 3")
    print(
        "Actual Output : ", solution.findLongestChain([[1, 2], [2, 3], [3, 4], [5, 6]])
    )
