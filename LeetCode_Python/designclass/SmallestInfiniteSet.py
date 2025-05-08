import heapq


class SmallestInfiniteSet:
    def __init__(self):
        self.cur = 1
        self.set = set()
        self.heap = []

    def popSmallest(self) -> int:
        if self.heap:
            val = heapq.heappop(self.heap)
            self.set.remove(val)
            return val
        else:
            self.cur += 1
            return self.cur - 1

    def addBack(self, num: int) -> None:
        if num < self.cur and num not in self.set:
            self.set.add(num)
            heapq.heappush(self.heap, num)


# Time Complexity:
# popSmallest: we will need to remove a number from the hash set which will take O(1) time
# the top of the min-heap which will take O(logn) time.
# Thus, for m calls it will take O(m⋅logn) time.
# addBack: we might push num in the hash set which will take O(1) time
# min-heap which will take O(logn) time.
# Thus, for n calls it will take O(n⋅logn) time.
# Space Complexity: O(n) for the set and heap

if __name__ == "__main__":
    solution = SmallestInfiniteSet()

    print("Expected Output: 1")
    print("Actual Output:", solution.popSmallest())

    print("Expected Output: 2")
    print("Actual Output:", solution.popSmallest())

    print("Expected Output: 3")
    print("Actual Output:", solution.popSmallest())

    print("Expected Output: 4")
    print("Actual Output:", solution.popSmallest())

    solution.addBack(2)
    print("Expected Output: 2")
    print("Actual Output:", solution.popSmallest())
