class UniquePathsII:
    def uniquePathsWithObstacles(self, obstacleGrid: list[list[int]]) -> int:
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        dp = [[0] * n for _ in range(m)]

        if obstacleGrid[0][0] == 1 or obstacleGrid[m - 1][n - 1] == 1:
            return 0

        for i in range(m):
            if obstacleGrid[i][0] == 1:
                break
            dp[i][0] = 1

        for j in range(n):
            if obstacleGrid[0][j] == 1:
                break
            dp[0][j] = 1

        for i in range(1, m):
            for j in range(1, n):
                if obstacleGrid[i][j] == 1:
                    dp[i][j] = 0
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]

        return dp[m - 1][n - 1]


# Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the obstacle grid.
# Space Complexity: O(m * n), for the dp array.

if __name__ == "__main__":
    solution = UniquePathsII()

    print("Expected Output : 2")
    print(
        "Actual Output : ",
        solution.uniquePathsWithObstacles([[0, 0, 0], [0, 1, 0], [0, 0, 0]]),
    )

    print("Expected Output : 0")
    print(
        "Actual Output : ", solution.uniquePathsWithObstacles([[0, 0], [1, 1], [0, 0]])
    )

    print("Expected Output : 1")
    print("Actual Output : ", solution.uniquePathsWithObstacles([[0, 0], [1, 0]]))
