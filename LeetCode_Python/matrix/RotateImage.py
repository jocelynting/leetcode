class RotateImage:
    def rotate(self, matrix: list[list[int]]) -> None:
        n = len(matrix)

        for i in range(n):
            for j in range(i + 1, n):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]

        for i in range(n):
            left, right = 0, n - 1
            while left < right:
                matrix[i][left], matrix[i][right] = matrix[i][right], matrix[i][left]
                left += 1
                right -= 1

        # matrix.reverse()
        # for i in range(n):
        #     for j in range(i + 1, n):
        #         matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]


if __name__ == "__main__":
    solution = RotateImage()

    matrix1 = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
    expected1 = [
        [7, 4, 1],
        [8, 5, 2],
        [9, 6, 3]
    ]
    solution.rotate(matrix1)
    print("Expected Output:", expected1)
    print("Actual Output:", matrix1)

    matrix2 = [
        [5, 1, 9, 11],
        [2, 4, 8, 10],
        [13, 3, 6, 7],
        [15, 14, 12, 16]
    ]
    expected2 = [
        [15, 13, 2, 5],
        [14, 3, 4, 1],
        [12, 6, 8, 9],
        [16, 7, 10, 11]
    ]
    solution.rotate(matrix2)
    print("Expected Output:", expected2)
    print("Actual Output:", matrix2)
