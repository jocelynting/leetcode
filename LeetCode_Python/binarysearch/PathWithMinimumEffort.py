from collections import deque


class PathWithMinimumEffort:
    def minimumEffortPath(self, heights: list[list[int]]) -> int:
        def calculate(target: int) -> bool:
            m, n = len(heights), len(heights[0])
            visited = [[False] * n for _ in range(m)]
            queue = deque([(0, 0)])
            directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

            while queue:
                row, col = queue.popleft()

                if row == m - 1 and col == n - 1:
                    return True

                for dr, dc in directions:
                    nr, nc = row + dr, col + dc
                    if 0 <= nr < m and 0 <= nc < n and not visited[nr][nc]:
                        diff = abs(heights[nr][nc] - heights[row][col])
                        if diff <= target:
                            visited[nr][nc] = True
                            queue.append((nr, nc))

            return False

        left, right = 0, 10**6

        while left < right:
            mid = left + (right - left) // 2
            if calculate(mid):
                right = mid
            else:
                left = mid + 1

        return left


# Time Complexity: O(m * n * log(max_height)), where m is the number of rows, n is the number of columns in the heights matrix, and max_height is the maximum height difference in the grid.
# Space Complexity: O(m * n), for the visited matrix and the queue used in BFS.

if __name__ == "__main__":
    solution = PathWithMinimumEffort()

    heights1 = [[1, 2, 2], [3, 8, 2], [5, 3, 5]]
    print("Expected Output: 2")
    print("Actual Output:", solution.minimumEffortPath(heights1))

    heights2 = [[1, 2, 3], [3, 8, 4], [5, 3, 5]]
    print("Expected Output: 1")
    print("Actual Output:", solution.minimumEffortPath(heights2))
