class MinimumFallingPathSum:
    def minFallingPathSum(self, matrix: list[list[int]]) -> int:
        n = len(matrix)
        dp = [[0] * n for _ in range(n)]
        dp[0] = matrix[0]

        for i in range(1, n):
            for j in range(n):
                dp[i][j] = matrix[i][j] + min(
                    dp[i - 1][j],
                    dp[i - 1][j - 1] if j > 0 else float("inf"),
                    dp[i - 1][j + 1] if j < n - 1 else float("inf"),
                )

        return min(dp[-1])


# Time Complexity: O(n^2), where n is the number of rows (or columns) in the matrix
# Space Complexity: O(n^2), for the dp array
if __name__ == "__main__":
    solution = MinimumFallingPathSum()

    matrix1 = [[2, 1, 3], [6, 5, 4], [7, 8, 9]]
    print("Expected Output: 13")
    print("Actual Output:", solution.minFallingPathSum(matrix1))

    matrix2 = [[-19, 57], [-40, -5]]
    print("Expected Output: -59")
    print("Actual Output:", solution.minFallingPathSum(matrix2))

    matrix3 = [[-48]]
    print("Expected Output: -48")
    print("Actual Output:", solution.minFallingPathSum(matrix3))
