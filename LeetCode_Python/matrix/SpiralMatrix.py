class SpiralMatrix:
    def spiralOrder(self, matrix: list[list[int]]) -> list[int]:
        res = []
        m, n = len(matrix), len(matrix[0])

        top, bottom = 0, m
        left, right = 0, n

        while left < right and top < bottom:
            for i in range(left, right):
                res.append(matrix[top][i])
            top += 1

            for i in range(top, bottom):
                res.append(matrix[i][right - 1])
            right -= 1

            if left >= right or top >= bottom:
                break

            for i in range(right - 1, left - 1, -1):
                res.append(matrix[bottom - 1][i])
            bottom -= 1

            for i in range(bottom - 1, top - 1, -1):
                res.append(matrix[i][left])
            left += 1

        return res


if __name__ == "__main__":
    solution = SpiralMatrix()
    matrix1 = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
    print("Expected Output:", [1, 2, 3, 6, 9, 8, 7, 4, 5])
    print("Actual Output:", solution.spiralOrder(matrix1))

    matrix2 = [
        [1, 2, 3, 4],
        [5, 6, 7, 8],
        [9, 10, 11, 12]
    ]
    print("Expected Output:", [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7])
    print("Actual Output:", solution.spiralOrder(matrix2))
