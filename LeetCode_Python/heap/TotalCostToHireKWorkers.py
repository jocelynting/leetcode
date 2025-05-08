import heapq


class TotalCostToHireKWorkers:
    def totalCost(self, costs: list[int], k: int, candidates: int) -> int:
        n = len(costs)
        heap = []

        for i in range(candidates):
            heapq.heappush(heap, (costs[i], 0))
        for i in range(max(candidates, n - candidates), n):
            heapq.heappush(heap, (costs[i], 1))

        res = 0
        first, last = candidates, n - candidates - 1

        for _ in range(k):
            cost, section = heapq.heappop(heap)
            res += cost

            if first <= last:
                if section == 0:
                    heapq.heappush(heap, (costs[first], 0))
                    first += 1
                else:
                    heapq.heappush(heap, (costs[last], 1))
                    last -= 1

        return res


# Time Complexity: O(k log k + n log n), where k is the number of workers to hire and n is the number of costs
# Space Complexity: O(n), for the heap and the costs array

if __name__ == "__main__":
    solution = TotalCostToHireKWorkers()

    print("Expected Output: 11")
    print("Actual Output:", solution.totalCost([17, 12, 10, 2, 7, 2, 11, 20, 8], 3, 4))

    print("Expected Output: 4")
    print("Actual Output:", solution.totalCost([1, 2, 4, 1], 3, 3))

    print("Expected Output: 423")
    print(
        "Actual Output:",
        solution.totalCost(
            [31, 25, 72, 79, 74, 65, 84, 91, 18, 59, 27, 9, 81, 33, 17, 58], 11, 2
        ),
    )
