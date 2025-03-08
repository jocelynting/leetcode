from collections import deque


class MovingAverage:
    def __init__(self, size: int):
        self.size = size
        self.queue = deque()
        self.total = 0

    def next(self, val: int) -> float:
        self.queue.append(val)
        self.total += val
        if len(self.queue) > self.size:
            removed = self.queue.popleft()
            self.total -= removed
        return self.total / len(self.queue)


if __name__ == "__main__":
    solution = MovingAverage(3)

    print("Expected Output : 1.0")
    print("Actual Output   : ", solution.next(1))
    print("Expected Output : 5.5")
    print("Actual Output   : ", solution.next(10))
    print("Expected Output : 4.66667")
    print("Actual Output   : ", solution.next(3))
    print("Expected Output : 6.0")
    print("Actual Output   : ", solution.next(5))
