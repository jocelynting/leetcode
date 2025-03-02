from collections import defaultdict
import heapq


class CheapestFlightsWithinKStops:
    def findCheapestPrice(self, n: int, flights: list[list[int]], src: int, dst: int, k: int) -> int:
        graph = defaultdict(list)
        for u, v, w in flights:
            graph[u].append((v, w))

        heap = [(0, src, 0)]
        visited = {}

        while heap:
            cost, city, stop = heapq.heappop(heap)

            if stop > k + 1:
                continue

            if city == dst:
                return cost

            if city in visited and visited[city] < stop:
                continue

            visited[city] = stop

            for nei, price in graph[city]:
                heapq.heappush(heap, (cost + price, nei, stop + 1))

        return -1


if __name__ == "__main__":
    solution = CheapestFlightsWithinKStops()
    n1 = 4
    flights1 = [[0, 1, 100], [1, 2, 100], [2, 3, 100], [0, 2, 500]]
    src1 = 0
    dst1 = 3
    K1 = 1
    print("Expected Output: 600")
    print("Actual Output:", solution.findCheapestPrice(
        n1, flights1, src1, dst1, K1))

    n2 = 3
    flights2 = [[0, 1, 100], [1, 2, 100], [0, 2, 500]]
    src2 = 0
    dst2 = 2
    K2 = 0
    print("Expected Output: 500")
    print("Actual Output:", solution.findCheapestPrice(
        n2, flights2, src2, dst2, K2))
