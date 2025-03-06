import heapq
from collections import Counter


class TaskScheduler:
    def leastInterval(self, tasks: list[str], n: int) -> int:
        count = Counter(tasks)

        heap = [-f for f in count.values() if f > 0]
        heapq.heapify(heap)

        res = 0

        while heap:
            cycle = n + 1
            remain = []
            task = 0
            while cycle > 0 and heap:
                cur_freq = -heapq.heappop(heap)
                if cur_freq > 1:
                    remain.append(-(cur_freq - 1))
                task += 1
                cycle -= 1

            for t in remain:
                heapq.heappush(heap, t)

            res += task if not heap else n + 1

        return res


if __name__ == "__main__":
    solution = TaskScheduler()

    tasks1 = ["A", "A", "A", "B", "B", "B"]
    n1 = 2
    print("Expected Output: 8")
    print("Actual Output:", solution.leastInterval(tasks1, n1))

    tasks2 = ["A", "A", "A", "B", "B", "B"]
    n2 = 0
    print("Expected Output: 6")
    print("Actual Output:", solution.leastInterval(tasks2, n2))

    tasks3 = ["A", "A", "A", "A", "A", "A", "B", "C", "D", "E", "F", "G"]
    n3 = 2
    print("Expected Output: 16")
    print("Actual Output:", solution.leastInterval(tasks3, n3))
