class MatrixDiagonalSum:
    def diagonalSum(self, mat: list[list[int]]) -> int:
        n = len(mat)
        res = 0

        for i in range(n):
            res += mat[i][i]
            res += mat[i][n - i - 1]

        if n % 2 == 1:
            res -= mat[n // 2][n // 2]

        return res


# Time Complexity: O(n), where n is the length of the matrix
# Space Complexity: O(1), no extra space is used

if __name__ == "__main__":
    solution = MatrixDiagonalSum()

    print("Expected Output: 25")
    print("Actual Output: ", solution.diagonalSum([[1, 2, 3], [4, 5, 6], [7, 8, 9]]))

    print("Expected Output: 8")
    print(
        "Actual Output: ",
        solution.diagonalSum([[1, 1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1]]),
    )

    print("Expected Output: 5")
    print("Actual Output: ", solution.diagonalSum([[5]]))
