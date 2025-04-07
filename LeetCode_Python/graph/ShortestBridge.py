from collections import deque


class ShortestBridge:
    def shortestBridge(self, grid: list[list[int]]) -> int:
        n = len(grid)
        queue = deque()

        def dfs(row: int, col: int) -> None:
            if row < 0 or row >= n or col < 0 or col >= n or grid[row][col] != 1:
                return
            grid[row][col] = -1
            queue.append((row, col))
            dfs(row + 1, col)
            dfs(row - 1, col)
            dfs(row, col + 1)
            dfs(row, col - 1)

        found = False
        for i in range(n):
            if found:
                break
            for j in range(n):
                if grid[i][j] == 1:
                    dfs(i, j)
                    found = True
                    break

        res = 0
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        while queue:
            size = len(queue)
            for _ in range(size):
                row, col = queue.popleft()
                for dr, dc in directions:
                    r, c = row + dr, col + dc
                    if 0 <= r < n and 0 <= c < n:
                        if grid[r][c] == 1:
                            return res
                        elif grid[r][c] == 0:
                            grid[r][c] = 2
                            queue.append((r, c))
            res += 1

        return -1


# Time Complexity: O(n^2), where n is the length of the grid. In the worst case, we may need to traverse all cells in the grid.
# Space Complexity: O(n^2), for the queue used in BFS and the grid itself.

if __name__ == "__main__":
    solution = ShortestBridge()

    grid = [[0, 1], [1, 0]]

    print("Expected Output: 1")
    print("Actual Output:", solution.shortestBridge(grid))

    grid = [[0, 1, 0], [0, 0, 0], [0, 0, 1]]

    print("Expected Output: 2")
    print("Actual Output:", solution.shortestBridge(grid))
