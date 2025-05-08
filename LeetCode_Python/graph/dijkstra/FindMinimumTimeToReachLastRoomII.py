import heapq


class FindMinimumTimeToReachLastRoomI:
    def minTimeToReach(self, moveTime: list[list[int]]) -> int:
        m, n = len(moveTime), len(moveTime[0])
        distances = [[float("inf")] * n for _ in range(m)]
        distances[0][0] = 0
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

        heap = [(0, 0, 0)]  # (distance, x, y)

        while heap:
            time, row, col = heapq.heappop(heap)

            if row == m - 1 and col == n - 1:
                return time

            if time > distances[row][col]:
                continue

            for dr, dc in directions:
                nr, nc = row + dr, col + dc
                if 0 <= nr < m and 0 <= nc < n:
                    next_time = max(time, moveTime[nr][nc]) + 1
                    if next_time < distances[nr][nc]:
                        distances[nr][nc] = next_time
                        heapq.heappush(heap, (next_time, nr, nc))

        return -1


# Time Complexity: O(m * n * log(m * n)), where m is the number of rows and n is the number of columns in the moveTime grid
# Space Complexity: O(m * n), for the distances array and the heap

if __name__ == "__main__":
    solution = FindMinimumTimeToReachLastRoomI()

    print("Expected Output: 6")
    print("Actual Output:", solution.minTimeToReach([[0, 4], [4, 4]]))

    print("Expected Output: 3")
    print("Actual Output:", solution.minTimeToReach([[0, 0, 0], [0, 0, 0]]))

    print("Expected Output: 3")
    print("Actual Output:", solution.minTimeToReach([[0, 1], [1, 2]]))
