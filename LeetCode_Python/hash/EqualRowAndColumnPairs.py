from collections import Counter


class EqualRowAndColumnPairs:
    def equalPairs(self, grid: list[list[int]]) -> int:
        n = len(grid)
        row_count = Counter(tuple(row) for row in grid)

        res = 0
        for j in range(n):
            col = tuple(grid[i][j] for i in range(n))
            res += row_count[col]

        return res


# Time Complexity: O(n^2), where n is the number of rows/columns in the grid.
# Space Complexity: O(n^2), we are storing n rows in the Counter, and each row is a tuple of n elements.

if __name__ == "__main__":
    solution = EqualRowAndColumnPairs()

    print("Expected Output: 1")
    print("Actual Output:", solution.equalPairs([[3, 2, 1], [1, 7, 6], [2, 7, 7]]))

    print("Expected Output: 3")
    print(
        "Actual Output:",
        solution.equalPairs([[3, 1, 2, 2], [1, 4, 4, 5], [2, 4, 2, 2], [2, 4, 2, 2]]),
    )
