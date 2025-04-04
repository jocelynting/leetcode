from collections import deque


class NumberOfDistinctIslands:
    def numDistinctIslands(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        shapes = set()

        def dfs(
            row: int, col: int, origin_row: int, origin_col: int, shape: list[int]
        ) -> None:
            if row < 0 or row >= m or col < 0 or col >= n or grid[row][col] == 0:
                return

            grid[row][col] = 0
            shape.append((row - origin_row, col - origin_col))

            dfs(row + 1, col, origin_row, origin_col, shape)
            dfs(row - 1, col, origin_row, origin_col, shape)
            dfs(row, col + 1, origin_row, origin_col, shape)
            dfs(row, col - 1, origin_row, origin_col, shape)

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    shape = []
                    dfs(i, j, i, j, shape)
                    shapes.add(tuple(shape))

        return len(shapes)

    def numDistinctIslandsByBFS(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        shapes = set()
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

        def bfs(start_row: int, start_col: int) -> tuple:
            queue = deque([(start_row, start_col)])
            shape = []
            grid[start_row][start_col] = 0

            while queue:
                row, col = queue.popleft()

                for dr, dc in directions:
                    new_row, new_col = row + dr, col + dc
                    if (
                        0 <= new_row < m
                        and 0 <= new_col < n
                        and grid[new_row][new_col] == 1
                    ):
                        grid[new_row][new_col] = 0
                        queue.append((new_row, new_col))
                        shape.append((new_row - start_row, new_col - start_col))

            return tuple(sorted(shape))

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    shape = bfs(i, j)
                    shapes.add(shape)

        return len(shapes)


# Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the grid
# Space Complexity: O(m * n) for the recursion stack and the shapes set

if __name__ == "__main__":
    solution = NumberOfDistinctIslands()
    grid = [
        [1, 1, 0, 0, 0],
        [1, 0, 0, 1, 1],
        [0, 0, 0, 1, 0],
        [1, 1, 0, 0, 0],
    ]
    print("Expected Output: 2")
    print("Actual Output:", solution.numDistinctIslands(grid))
    grid = [
        [1, 1, 0, 0, 0],
        [1, 0, 0, 1, 1],
        [0, 0, 0, 1, 0],
        [1, 1, 0, 0, 0],
    ]
    print("Actual Output:", solution.numDistinctIslandsByBFS(grid))

    grid = [
        [1, 1, 0, 0, 0],
        [1, 1, 0, 1, 1],
        [0, 0, 0, 1, 0],
        [1, 1, 0, 0, 0],
    ]
    print("Expected Output: 3")
    print("Actual Output:", solution.numDistinctIslands(grid))
    grid = [
        [1, 1, 0, 0, 0],
        [1, 1, 0, 1, 1],
        [0, 0, 0, 1, 0],
        [1, 1, 0, 0, 0],
    ]
    print("Actual Output:", solution.numDistinctIslandsByBFS(grid))
