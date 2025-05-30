class MaximalSquare:
    def maximalSquare(self, matrix: list[list[str]]) -> int:
        m, n = len(matrix), len(matrix[0])

        dp = [[0] * n for _ in range(m)]
        res = 0

        for i in range(m):
            dp[i][0] = int(matrix[i][0])
            res = max(res, dp[i][0])

        for j in range(n):
            dp[0][j] = int(matrix[0][j])
            res = max(res, dp[0][j])

        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][j] == "1":
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
                    res = max(res, dp[i][j])

        return res * res


# Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the matrix
# Space Complexity: O(m * n), for the dp array


if __name__ == "__main__":
    solution = MaximalSquare()

    matrix1 = [
        ["1", "0", "1", "0", "0"],
        ["1", "0", "1", "1", "1"],
        ["1", "1", "1", "1", "1"],
        ["1", "0", "0", "1", "0"],
    ]

    print("Expected Output : 4")
    print("Actual Output : ", solution.maximalSquare(matrix1))

    matrix2 = [["0", "1"], ["1", "0"]]
    print("Expected Output : 1")
    print("Actual Output : ", solution.maximalSquare(matrix2))
