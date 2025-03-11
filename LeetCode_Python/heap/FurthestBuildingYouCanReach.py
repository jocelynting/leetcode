import heapq


class FurthestBuildingYouCanReach:
    def furthestBuilding(self, heights: list[int], bricks: int, ladders: int) -> int:
        n = len(heights)
        heap = []

        for i in range(n - 1):
            diff = heights[i + 1] - heights[i]
            if diff > 0:
                heapq.heappush(heap, diff)
            if len(heap) > ladders:
                bricks -= heapq.heappop(heap)
            if bricks < 0:
                return i

        return n - 1


if __name__ == "__main__":
    solution = FurthestBuildingYouCanReach()

    print("Expected Output: 4")
    print("Actual Output:", solution.furthestBuilding([4, 2, 7, 6, 9, 14, 12], 5, 1))

    print("Expected Output: 7")
    print(
        "Actual Output:",
        solution.furthestBuilding([4, 12, 2, 7, 3, 18, 20, 3, 19], 10, 2),
    )

    print("Expected Output: 3")
    print("Actual Output:", solution.furthestBuilding([14, 3, 19, 3], 17, 0))
