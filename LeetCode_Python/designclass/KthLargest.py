import heapq


class KthLargest:
    def __init__(self, k: int, nums: list[int]):
        self.heap = []
        self.k = k
        for n in nums:
            self.add(n)

    def add(self, val: int) -> int:
        if len(self.heap) < self.k:
            heapq.heappush(self.heap, val)
        elif val > self.heap[0]:
            heapq.heapreplace(self.heap, val)

        return self.heap[0]


if __name__ == "__main__":
    solution = KthLargest(3, [4, 5, 8, 2])

    print("Expected Output: 4")
    print("Actual Output:", solution.add(3))

    print("Expected Output: 5")
    print("Actual Output:", solution.add(5))

    print("Expected Output: 5")
    print("Actual Output:", solution.add(10))

    print("Expected Output: 8")
    print("Actual Output:", solution.add(9))

    print("Expected Output: 8")
    print("Actual Output:", solution.add(4))

    print("Expected Output: 9")
    print("Actual Output:", solution.add(10))

    print("Expected Output: 10")
    print("Actual Output:", solution.add(10))
