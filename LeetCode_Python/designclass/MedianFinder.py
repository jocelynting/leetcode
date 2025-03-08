import heapq


class MedianFinder:

    def __init__(self):
        self.max_heap = []
        self.min_heap = []

    def addNum(self, num: int) -> None:
        heapq.heappush(self.max_heap, -num)
        heapq.heappush(self.min_heap, -heapq.heappop(self.max_heap))

        if len(self.min_heap) > len(self.max_heap):
            heapq.heappush(self.max_heap, -heapq.heappop(self.min_heap))

    def findMedian(self) -> float:
        if len(self.max_heap) == len(self.min_heap):
            return (self.min_heap[0] - self.max_heap[0]) / 2
        else:
            return -self.max_heap[0]


if __name__ == "__main__":
    solution = MedianFinder()

    solution.addNum(1)
    solution.addNum(2)

    print("Expected Output : 1.5")
    print("Actual Output : ", solution.findMedian())

    solution.addNum(3)
    print("Expected Output : 2")
    print("Actual Output : ", solution.findMedian())
