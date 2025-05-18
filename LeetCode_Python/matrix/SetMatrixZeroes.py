class SetMatrixZeroes:
    def setZeroes(self, matrix: list[list[int]]) -> None:
        m, n = len(matrix), len(matrix[0])

        frz = any([matrix[0][j] == 0 for j in range(n)])
        fcz = any([matrix[i][0] == 0 for i in range(m)])

        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][j] == 0:
                    matrix[i][0] = matrix[0][j] = 0

        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][0] == 0 or matrix[0][j] == 0:
                    matrix[i][j] = 0

        if frz:
            for j in range(n):
                matrix[0][j] = 0

        if fcz:
            for i in range(m):
                matrix[i][0] = 0


# Time Complexity: O(m * n)
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = SetMatrixZeroes()

    matrix = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
    solution.setZeroes(matrix)

    print("Expected Output: [[1, 0, 1], [0, 0, 0], [1, 0, 1]]")
    print("Actual Output:", matrix)

    matrix = [[0, 1, 2, 0], [3, 4, 5, 2], [1, 3, 1, 5]]
    solution.setZeroes(matrix)

    print("Expected Output: [[0, 0, 0, 0], [0, 4, 5, 0], [0, 3, 1, 0]]")
    print("Actual Output:", matrix)
