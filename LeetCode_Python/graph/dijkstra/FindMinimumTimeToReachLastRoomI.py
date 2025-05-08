import heapq


class FindMinimumTimeToReachLastRoomII:
    def minTimeToReach(self, moveTime: list[list[int]]) -> int:
        m, n = len(moveTime), len(moveTime[0])
        distances = [[float("inf")] * n for _ in range(m)]
        distances[0][0] = 0
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

        heap = [(0, 0, 0, 0)]  # (time, x, y, steps)

        while heap:
            time, row, col, steps = heapq.heappop(heap)

            if row == m - 1 and col == n - 1:
                return time

            if time > distances[row][col]:
                continue

            for dr, dc in directions:
                nr, nc = row + dr, col + dc
                if 0 <= nr < m and 0 <= nc < n:
                    move_cost = 1 if steps % 2 == 0 else 2
                    next_time = max(time, moveTime[nr][nc]) + move_cost
                    if next_time < distances[nr][nc]:
                        distances[nr][nc] = next_time
                        heapq.heappush(heap, (next_time, nr, nc, steps + 1))

        return -1


# Time Complexity: O(m * n * log(m * n)), where m is the number of rows and n is the number of columns in the moveTime grid
# Space Complexity: O(m * n), for the distances array and the heap

if __name__ == "__main__":
    solution = FindMinimumTimeToReachLastRoomII()

    print("Expected Output: 7")
    print("Actual Output:", solution.minTimeToReach([[0, 4], [4, 4]]))

    print("Expected Output: 6")
    print("Actual Output:", solution.minTimeToReach([[0, 0, 0, 0], [0, 0, 0, 0]]))

    print("Expected Output: 4")
    print("Actual Output:", solution.minTimeToReach([[0, 1], [1, 2]]))
