import heapq


class KClosestPointsToOrigin:
    def kClosest(self, points: list[list[int]], k: int) -> list[list[int]]:
        max_heap = []

        for x, y in points:
            dist = -(x**2 + y**2)
            heapq.heappush(max_heap, (dist, [x, y]))
            if len(max_heap) > k:
                heapq.heappop(max_heap)

        return [point for _, point in max_heap]


# Time Complexity: O(N log K), where N is the number of points
# Space Complexity: O(K), for the max heap

if __name__ == "__main__":
    solution = KClosestPointsToOrigin()

    points = [[1, 3], [-2, 2]]
    k = 1
    print("Expected Output: [[-2, 2]]")
    print("Actual Output:", solution.kClosest(points, k))

    points = [[3, 3], [5, -1], [-2, 4]]
    k = 2
    print("Expected Output: [[-2, 4], [3, 3]]")
    print("Actual Output:", solution.kClosest(points, k))
