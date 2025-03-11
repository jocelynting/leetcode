from collections import deque
import copy


class MaxAreaOfIsland:
    def maxAreaOfIsland(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        visited = [[False] * n for _ in range(m)]
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        res = 0

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1 and not visited[i][j]:
                    area = 0
                    queue = deque([(i, j)])
                    visited[i][j] = True

                    while queue:
                        row, col = queue.popleft()
                        area += 1

                        for d in directions:
                            r, c = row + d[0], col + d[1]

                            if (
                                0 <= r < m
                                and 0 <= c < n
                                and grid[r][c] == 1
                                and not visited[r][c]
                            ):
                                visited[r][c] = True
                                queue.append((r, c))

                    res = max(res, area)
        return res

    def maxAreaOfIslandByDFS(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        visited = [[False] * n for _ in range(m)]

        def dfs(row: int, col: int) -> int:
            if (
                row < 0
                or row >= m
                or col < 0
                or col >= n
                or visited[row][col]
                or grid[row][col] == 0
            ):
                return 0

            visited[row][col] = True
            area = 1

            area += dfs(row + 1, col)
            area += dfs(row - 1, col)
            area += dfs(row, col + 1)
            area += dfs(row, col - 1)

            return area

        res = 0

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    res = max(res, dfs(i, j))

        return res

    def maxAreaOfIslandByUnionFind(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        size = m * n
        uf = UnionFind(size)
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        for i in range(m):
            for j in range(n):
                index = i * n + j
                if grid[i][j] == 1:
                    for d in directions:
                        r, c = i + d[0], j + d[1]
                        if 0 <= r < m and 0 <= c < n and grid[r][c] == 1:
                            uf.union(index, r * n + c)

        res = 0
        for i in range(size):
            if uf.find(i) == i:
                res = max(res, uf.count[i])
        return res


class UnionFind:
    def __init__(self, size: int):
        self.parent = [i for i in range(size)]
        self.rank = [0] * size
        self.count = [1] * size

    def find(self, p: int) -> int:
        if self.parent[p] != p:
            self.parent[p] = self.find(self.parent[p])
        return self.parent[p]

    def union(self, p: int, q: int) -> None:
        root_p = self.find(p)
        root_q = self.find(q)

        if root_p == root_q:
            return

        if self.rank[root_p] > self.rank[root_q]:
            self.parent[root_q] = root_p
            self.count[root_p] += self.count[root_q]
        elif self.rank[root_p] < self.rank[root_q]:
            self.parent[root_p] = root_q
            self.count[root_q] += self.count[root_p]
        else:
            self.parent[root_q] = root_p
            self.count[root_p] += self.count[root_q]
            self.rank[root_p] += 1


if __name__ == "__main__":
    solution = MaxAreaOfIsland()

    grid = [
        [0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
        [0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0],
        [0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0],
    ]
    print("Expected Output:", 6)
    print("Actual Output:", solution.maxAreaOfIsland(grid))

    grid = copy.deepcopy(grid)
    print("Expected Output:", 6)
    print("Actual Output:", solution.maxAreaOfIslandByDFS(grid))

    grid = copy.deepcopy(grid)
    print("Expected Output:", 6)
    print("Actual Output:", solution.maxAreaOfIslandByUnionFind(grid))
