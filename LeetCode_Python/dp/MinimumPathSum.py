class MinimumPathSum:
    def minPathSum(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        dp = [[0] * n for _ in range(m)]
        dp[0][0] = grid[0][0]

        for i in range(1, m):
            dp[i][0] = dp[i - 1][0] + grid[i][0]
        for j in range(1, n):
            dp[0][j] = dp[0][j - 1] + grid[0][j]

        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]

        return dp[-1][-1]


# Time Complexity: O(m * n), where m is the number of rows and n is the number of columns
# Space Complexity: O(m * n), for the dp array

if __name__ == "__main__":
    solution = MinimumPathSum()

    grid1 = [[1, 3, 1], [1, 5, 1], [4, 2, 1]]
    print("Expected Output: 7")
    print("Actual Output:", solution.minPathSum(grid1))

    grid2 = [[1, 2, 3], [4, 5, 6]]
    print("Expected Output: 12")
    print("Actual Output:", solution.minPathSum(grid2))

    grid3 = [[1, 2], [5, 6], [1, 1]]
    print("Expected Output: 8")
    print("Actual Output:", solution.minPathSum(grid3))
