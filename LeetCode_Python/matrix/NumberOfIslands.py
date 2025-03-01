class NumberOfIslands:
  def numIslands(self, grid: list[list[str]]) -> int:
        m, n = len(grid), len(grid[0])
        count = 0

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
                    count += 1
                    dfs(r, c)
        
        return count
  
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
