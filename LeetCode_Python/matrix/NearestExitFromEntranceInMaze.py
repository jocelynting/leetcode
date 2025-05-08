from collections import deque


class NearestExitFromEntranceInMaze:
    def nearestExit(self, maze: list[list[str]], entrance: list[int]) -> int:
        m, n = len(maze), len(maze[0])
        queue = deque([(entrance[0], entrance[1], 0)])
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        maze[entrance[0]][entrance[1]] = "+"

        while queue:
            row, col, dist = queue.popleft()

            if (row != entrance[0] or col != entrance[1]) and (
                row == 0 or row == m - 1 or col == 0 or col == n - 1
            ):
                return dist

            for dr, dc in directions:
                nr, nc = row + dr, col + dc
                if 0 <= nr < m and 0 <= nc < n and maze[nr][nc] == ".":
                    maze[nr][nc] = "+"
                    queue.append((nr, nc, dist + 1))

        return -1


# Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the maze
# Space Complexity: O(m * n), for the queue and the maze itself

if __name__ == "__main__":
    solution = NearestExitFromEntranceInMaze()

    maze = [["+", "+", ".", "+"], [".", ".", ".", "+"], ["+", "+", "+", "."]]
    entrance = [1, 2]
    print("Expected Output: 1")
    print("Actual Output:", solution.nearestExit(maze, entrance))

    maze = [["+", "+", "+"], [".", ".", "."], ["+", "+", "+"]]
    entrance = [1, 0]
    print("Expected Output: 2")
    print("Actual Output:", solution.nearestExit(maze, entrance))
