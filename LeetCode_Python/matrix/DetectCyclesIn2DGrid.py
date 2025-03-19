from collections import deque


class DetectCyclesIn2DGrid:
    def containsCycle(self, grid: list[list[str]]) -> bool:
        m, n = len(grid), len(grid[0])
        visited = [[False] * n for _ in range(m)]
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        def dfs(row: int, col: int, pr: int, pc: int, s: str, count: int) -> bool:
            visited[row][col] = True
            for dr, dc in directions:
                r, c = row + dr, col + dc
                if 0 <= r < m and 0 <= c < n and grid[r][c] == s:
                    if not visited[r][c]:
                        if dfs(r, c, row, col, s, count + 1):
                            return True
                    elif (r, c) != (pr, pc) and count >= 4:
                        return True
            return False

        for i in range(m):
            for j in range(n):
                if not visited[i][j] and dfs(i, j, -1, -1, grid[i][j], 1):
                    return True
        return False

    def containsCycleByBFS(self, grid: list[list[str]]) -> bool:
        m, n = len(grid), len(grid[0])
        visited = [[False] * n for _ in range(m)]
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        def bfs(row: int, col: int) -> bool:
            queue = deque([(row, col, -1, -1)])
            visited[row][col] = True
            s = grid[row][col]

            while queue:
                r, c, pr, pc = queue.popleft()
                for dr, dc in directions:
                    nr, nc = r + dr, c + dc
                    if 0 <= nr < m and 0 <= nc < n and grid[nr][nc] == s:
                        if (nr, nc) == (pr, pc):
                            continue
                        if visited[nr][nc]:
                            return True
                        visited[nr][nc] = True
                        queue.append((nr, nc, r, c))
            return False

        for i in range(m):
            for j in range(n):
                if not visited[i][j] and bfs(i, j):
                    return True

        return False


if __name__ == "__main__":
    solution = DetectCyclesIn2DGrid()

    grid1 = [
        ["a", "a", "a", "a"],
        ["a", "b", "b", "a"],
        ["a", "b", "b", "a"],
        ["a", "a", "a", "a"],
    ]
    print("Expected: True")
    print("Output:", solution.containsCycle(grid1))
    print("Output:", solution.containsCycleByBFS(grid1))

    grid2 = [
        ["c", "c", "c", "a"],
        ["c", "d", "c", "c"],
        ["c", "c", "e", "c"],
        ["f", "c", "c", "c"],
    ]
    print("Expected: True")
    print("Output:", solution.containsCycle(grid2))
    print("Output:", solution.containsCycleByBFS(grid2))

    grid3 = [
        ["a", "b", "b"],
        ["b", "z", "b"],
        ["b", "b", "a"],
    ]
    print("Expected: False")
    print("Output:", solution.containsCycle(grid3))
    print("Output:", solution.containsCycleByBFS(grid3))
