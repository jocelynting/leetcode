import random
import bisect


class RandomPickWithWeight:
    def __init__(self, w: list[int]):
        self.prefix_sum = []
        total = 0
        for weight in w:
            total += weight
            self.prefix_sum.append(total)
        self.total = total

    def pickIndex(self) -> int:
        target = random.randint(1, self.total)
        left, right = 0, len(self.prefix_sum)
        while left < right:
            mid = left + (right - left) // 2
            if self.prefix_sum[mid] < target:
                left = mid + 1
            else:
                right = mid
        return left
        # index = bisect.bisect_left(self.prefix_sum, target)
        # return index


# Time Complexity: O(log n) for pickIndex
# Space Complexity: O(n) for prefix_sum

if __name__ == "__main__":
    solution = RandomPickWithWeight([1, 3])

    print("Expected Output: 1")
    print("Actual Output: ", solution.pickIndex())

    print("Expected Output: 1")
    print("Actual Output: ", solution.pickIndex())

    print("Expected Output: 1")
    print("Actual Output: ", solution.pickIndex())

    print("Expected Output: 0")
    print("Actual Output: ", solution.pickIndex())
