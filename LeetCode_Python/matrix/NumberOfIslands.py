from collections import deque


class NumberOfIslands:
    def numIslands(self, grid: list[list[str]]) -> int:
        m, n = len(grid), len(grid[0])
        res = 0

        def dfs(row: int, col: int) -> None:
            if row < 0 or row >= m or col < 0 or col >= n or grid[row][col] == "0":
                return
            grid[row][col] = "0"
            dfs(row - 1, col)
            dfs(row + 1, col)
            dfs(row, col - 1)
            dfs(row, col + 1)

        for r in range(m):
            for c in range(n):
                if grid[r][c] == "1":
                    res += 1
                    dfs(r, c)

        return res

    def numIslandsByBFS(self, grid: list[list[str]]) -> int:
        m, n = len(grid), len(grid[0])
        res = 0
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        def bfs(row: int, col: int) -> None:
            queue = deque([(row, col)])
            while queue:
                r, c = queue.popleft()
                for dr, dc in directions:
                    new_r, new_c = r + dr, c + dc
                    if 0 <= new_r < m and 0 <= new_c < n and grid[new_r][new_c] == "1":
                        grid[new_r][new_c] = "0"
                        queue.append((new_r, new_c))

        for r in range(m):
            for c in range(n):
                if grid[r][c] == "1":
                    res += 1
                    grid[r][c] = "0"
                    bfs(r, c)

        return res


if __name__ == "__main__":
    solution = NumberOfIslands()
    grid1 = [
        ["1", "1", "1", "1", "0"],
        ["1", "1", "0", "1", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "0", "0", "0"],
    ]
    print("Expected Output: 1")
    print("Actual Output:", solution.numIslands([row[:] for row in grid1]))
    print("Actual Output:", solution.numIslandsByBFS([row[:] for row in grid1]))

    grid2 = [
        ["1", "1", "0", "0", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "1", "0", "0"],
        ["0", "0", "0", "1", "1"],
    ]

    print("Expected Output: 3")
    print("Actual Output:", solution.numIslands([row[:] for row in grid2]))
    print("Actual Output:", solution.numIslandsByBFS([row[:] for row in grid2]))
