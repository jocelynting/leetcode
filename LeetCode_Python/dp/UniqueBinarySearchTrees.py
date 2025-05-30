class UniqueBinarySearchTrees:
    def numTrees(self, n: int) -> int:
        dp = [0] * (n + 1)
        dp[0], dp[1] = 1, 1

        for i in range(2, n + 1):
            for j in range(1, i + 1):
                dp[i] += dp[j - 1] * dp[i - j]

        return dp[n]


# Time Complexity: O(n^2), where n is the number of nodes
# Space Complexity: O(n), for the dp array

if __name__ == "__main__":
    solution = UniqueBinarySearchTrees()

    print("Expected Output: 5")
    print("Actual Output:", solution.numTrees(3))

    print("Expected Output: 14")
    print("Actual Output:", solution.numTrees(4))

    print("Expected Output: 1")
    print("Actual Output:", solution.numTrees(1))
