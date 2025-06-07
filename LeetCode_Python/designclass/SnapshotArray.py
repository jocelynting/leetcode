class SnapshotArray:

    def __init__(self, length: int):
        self.snap_id = 0
        self.data = {}

    def set(self, index: int, val: int) -> None:
        if index not in self.data:
            self.data[index] = []

        if self.data[index] and self.data[index][-1][0] == self.snap_id:
            self.data[index][-1] = (self.snap_id, val)
        else:
            self.data[index].append((self.snap_id, val))

    def snap(self) -> int:
        self.snap_id += 1
        return self.snap_id - 1

    def get(self, index: int, snap_id: int) -> int:
        if index not in self.data:
            return 0

        values = self.data[index]
        left, right = 0, len(values)
        while left < right:
            mid = left + (right - left) // 2
            if values[mid][0] <= snap_id:
                left = mid + 1
            else:
                right = mid

        return values[left - 1][1] if left != 0 else 0


# Time Complexity:
# - set: O(1) on average, amortized over multiple calls.
# - snap: O(1).
# - get: O(log n) due to binary search on the list of snapshots.
# Space Complexity:
# - O(n) for storing the snapshots, where n is the number of unique indices set.

if __name__ == "__main__":
    solution = SnapshotArray(3)
    solution.set(0, 5)

    print("Expected Output: 0")
    print("Actual Output:", solution.snap())

    solution.set(0, 6)
    print("Expected Output: 1")
    print("Actual Output:", solution.snap())

    solution.set(1, 2)
    print("Expected Output: 2")
    print("Actual Output:", solution.snap())

    print("Expected Output: 5")
    print("Actual Output:", solution.get(0, 0))

    print("Expected Output: 6")
    print("Actual Output:", solution.get(0, 1))
