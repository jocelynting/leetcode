from collections import deque

class RottingOranges:
  def orangesRotting(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        fresh = 0

        queue = deque()

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh += 1
                if grid[i][j] == 2:
                    queue.append((i, j))
        
        if fresh == 0:
            return 0
        
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        minutes = 0

        while queue:
            size = len(queue)
            for _ in range(size):
                i, j = queue.popleft()
                for r, c in directions:
                    row, col = i + r, j + c
                    if 0 <= row < m and 0 <= col < n and grid[row][col] == 1:
                        grid[row][col] = 2
                        fresh -= 1
                        queue.append((row, col))
            
            if queue:
                minutes += 1

        return minutes if fresh == 0 else -1

if __name__ == '__main__':
    solution = RottingOranges()
    
    grid1 = [
        [2,1,1],
        [1,1,0],
        [0,1,1]
    ]
    print("Expected Output: 4")
    print("Actual Output:", solution.orangesRotting([row[:] for row in grid1]))  
    
    grid2 = [
        [2,2,0],
        [0,2,2],
        [2,0,2]
    ]
    print("Expected Output: 0")
    print("Actual Output:", solution.orangesRotting([row[:] for row in grid2]))
    
    grid3 = [
        [2,1,1],
        [0,1,1],
        [1,0,1]
    ]
    print("Expected Output: -1")
    print("Actual Output:", solution.orangesRotting([row[:] for row in grid3]))
    print()