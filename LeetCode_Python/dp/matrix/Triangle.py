class Triangle:
    def minimumTotal(self, triangle: list[list[int]]) -> int:
        n = len(triangle)
        dp = triangle[-1]

        for i in range(n - 2, -1, -1):
            for j in range(len(triangle[i])):
                dp[j] = triangle[i][j] + min(dp[j], dp[j + 1])

        return dp[0]

    # Time Complexity: O(n^2), where n is the number of rows in the triangle.
    # Space Complexity: O(n), where n is the number of rows in the triangle.

    def minimumTotalBy2DDP(self, triangle: list[list[int]]) -> int:
        n = len(triangle)
        dp = [[0] * len(row) for row in triangle]
        dp[-1] = triangle[-1]

        for i in range(n - 2, -1, -1):
            for j in range(len(triangle[i])):
                dp[i][j] = triangle[i][j] + min(dp[i + 1][j], dp[i + 1][j + 1])

        return dp[0][0]

    # Time Complexity: O(n^2), where n is the number of rows in the triangle.
    # Space Complexity: O(n^2), where n is the number of rows in the triangle.


if __name__ == "__main__":
    solution = Triangle()

    triangle1 = [[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]]
    print("Expected Output: 11")
    print("Actual Output:", solution.minimumTotal(triangle1))
    triangle1 = [[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]]
    print("Actual Output:", solution.minimumTotalBy2DDP(triangle1))

    triangle2 = [[-10]]
    print("Expected Output: -10")
    print("Actual Output:", solution.minimumTotal(triangle2))
    print("Actual Output:", solution.minimumTotalBy2DDP(triangle2))
