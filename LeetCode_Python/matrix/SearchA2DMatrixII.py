class SearchA2DMatrixII:
    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])
        row, col = 0, n - 1

        while row < m and col >= 0:
            if matrix[row][col] == target:
                return True
            elif matrix[row][col] < target:
                row += 1
            else:
                col -= 1

        return False


# Time Complexity: O(m + n), where m is the number of rows and n is the number of columns in the matrix
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = SearchA2DMatrixII()

    matrix = [[1, 4, 7, 11], [2, 5, 8, 12], [3, 6, 9, 16], [10, 13, 14, 17]]
    target = 5
    print("Expected Output: True")
    print("Actual Output:", solution.searchMatrix(matrix, target))

    matrix = [[1, 4, 7, 11], [2, 5, 8, 12], [3, 6, 9, 16], [10, 13, 14, 17]]
    target = 20
    print("Expected Output: False")
    print("Actual Output:", solution.searchMatrix(matrix, target))
