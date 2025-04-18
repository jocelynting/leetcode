from collections import deque


class ShortestPathInBinaryMatrix:
    def shortestPathBinaryMatrix(self, grid: list[list[int]]) -> int:
        n = len(grid)

        if grid[0][0] == 1 or grid[n - 1][n - 1] == 1:
            return -1

        directions = [
            (0, -1),
            (0, 1),
            (-1, 0),
            (1, 0),
            (-1, -1),
            (1, 1),
            (-1, 1),
            (1, -1),
        ]
        queue = deque([(0, 0, 1)])
        grid[0][0] = 1

        while queue:
            row, col, dist = queue.popleft()
            if row == n - 1 and col == n - 1:
                return dist

            for dr, dc in directions:
                r, c = row + dr, col + dc
                if 0 <= r < n and 0 <= c < n and grid[r][c] == 0:
                    grid[r][c] = 1
                    queue.append((r, c, dist + 1))

        return -1


# Time Complexity: O(n^2), since the grid has n^2 cells and we may visit each cell once.
# Space Complexity: O(n^2), for the queue and the grid.

if __name__ == "__main__":
    solution = ShortestPathInBinaryMatrix()

    grid1 = [[0, 0, 0], [1, 1, 0], [1, 1, 0]]
    print("Expected Output: ", 4)
    print("Actual Output: ", solution.shortestPathBinaryMatrix(grid1))

    grid2 = [[0, 0, 0], [1, 1, 1], [1, 1, 0]]
    print("Expected Output: ", -1)
    print("Actual Output: ", solution.shortestPathBinaryMatrix(grid2))
