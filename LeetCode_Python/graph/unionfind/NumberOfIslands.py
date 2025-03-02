class UnionFind:
    def __init__(self, grid: list[list[str]]):
        self.m = len(grid)
        self.n = len(grid[0]) if self.m else 0
        size = self.m * self.n
        self.parent = [-1] * size
        self.rank = [0] * size
        self.count = 0

        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == "1":
                    index = i * self.n + j
                    self.parent[index] = index
                    self.count += 1
    
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
        elif self.rank[root_p] < self.rank[root_q]:
            self.parent[root_p] = root_q
        else:
            self.parent[root_q] = root_p
            self.rank[root_p] += 1
        self.count -= 1

class NumberOfIslands:
  def numIslands(self, grid: list[list[str]]) -> int:
      m, n = len(grid), len(grid[0])
      uf = UnionFind(grid)

      directions = [(0, 1), (1, 0)]
      for i in range(m):
        for j in range(n):
            if grid[i][j] == '1':
              for d in directions:
                  r, c = i + d[0], j + d[1]
                  if 0 <= r < m and 0 <= c < n and grid[r][c] == '1':
                      uf.union(i * n + j, r * n + c)
        
      return uf.count
  
if __name__ == "__main__":
    solution = NumberOfIslands()
    grid1 = [
        ["1","1","1","1","0"],
        ["1","1","0","1","0"],
        ["1","1","0","0","0"],
        ["0","0","0","0","0"]
    ]
    print("Expected Output: 1")
    print("Actual Output:", solution.numIslands([row[:] for row in grid1])) 
    
    grid2 = [
        ["1","1","0","0","0"],
        ["1","1","0","0","0"],
        ["0","0","1","0","0"],
        ["0","0","0","1","1"]
    ]

    print("Expected Output: 3")
    print("Actual Output:", solution.numIslands([row[:] for row in grid2])) 