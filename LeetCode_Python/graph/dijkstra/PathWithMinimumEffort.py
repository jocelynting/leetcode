import heapq


class PathWithMinimumEffort:
    def minimumEffortPath(self, heights: list[list[int]]) -> int:
        m, n = len(heights), len(heights[0])
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        efforts = [[float("inf")] * n for _ in range(m)]
        efforts[0][0] = 0

        heap = [(0, 0, 0)]

        while heap:
            row, col, effort = heapq.heappop(heap)
            if effort > efforts[row][col]:
                continue
            if row == m - 1 and col == n - 1:
                return effort

            for dr, dc in directions:
                r, c = row + dr, col + dc
                if 0 <= r < m and 0 <= c < n:
                    diff = abs(heights[row][col] - heights[r][c])
                    new_effort = max(effort, diff)
                    if new_effort < efforts[r][c]:
                        efforts[r][c] = new_effort
                        heapq.heappush(heap, (r, c, new_effort))

        return -1


# Time Complexity: O(m * n * log(m * n)), where m is the number of rows and n is the number of columns in the heights matrix.
# log(m * n) is due to the heap operations.
# Space Complexity: O(m * n), for the efforts matrix and the heap.

if __name__ == "__main__":
    solution = PathWithMinimumEffort()

    heights1 = [[1, 2, 2], [3, 8, 2], [5, 3, 5]]
    print("Expected Output: 2")
    print("Actual Output:", solution.minimumEffortPath(heights1))

    heights2 = [[1, 2, 3], [3, 8, 4], [5, 3, 5]]
    print("Expected Output: 1")
    print("Actual Output:", solution.minimumEffortPath(heights2))
