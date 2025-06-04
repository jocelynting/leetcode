class CountNegativeNumbersInASortedMatrix:
    def countNegatives(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        row, col = 0, n - 1
        res = 0

        while row < m and col >= 0:
            if grid[row][col] < 0:
                res += m - row
                col -= 1
            else:
                row += 1

        return res


# Time Complexity: O(m + n), where m is the number of rows and n is the number of columns in the grid.
# Space Complexity: O(1), as we are using a constant amount of space.

if __name__ == "__main__":
    solution = CountNegativeNumbersInASortedMatrix()

    print("Expected Output: 8")
    print(
        "Actual Output:",
        solution.countNegatives(
            [[4, 3, 2, -1], [3, 2, 1, -1], [1, 1, -1, -2], [-1, -1, -2, -3]]
        ),
    )

    print("Expected Output: 0")
    print("Actual Output:", solution.countNegatives([[3, 2], [1, 0]]))

    print("Expected Output: 3")
    print("Actual Output:", solution.countNegatives([[5, 1, 0], [-5, -5, -5]]))
