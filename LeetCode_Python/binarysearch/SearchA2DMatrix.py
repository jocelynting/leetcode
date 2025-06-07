class SearchA2DMatrix:
    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])
        left, right = 0, m * n

        while left < right:
            mid = left + (right - left) // 2
            num = matrix[mid // n][mid % n]

            if num < target:
                left = mid + 1
            elif num > target:
                right = mid
            else:
                return True

        return False


# Time Complexity: O(log(m * n)), where m is the number of rows and n is the number of columns in the matrix.
# Space Complexity: O(1), as we are using a constant amount of space for variables.

if __name__ == "__main__":
    solution = SearchA2DMatrix()

    matrix = [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60], [61, 66, 70, 80]]
    target = 3
    print("Expected Output: True")
    print("Actual Output:", solution.searchMatrix(matrix, target))

    target = 13
    print("Expected Output: False")
    print("Actual Output:", solution.searchMatrix(matrix, target))
