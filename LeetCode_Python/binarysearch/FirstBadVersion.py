class FirstBadVersion:
    def __init__(self, bad_version: int):
        self.bad_version = bad_version

    def isBadVersion(self, version: int) -> bool:
        return version >= self.bad_version

    def firstBadVersion(self, n: int) -> int:
        left, right = 1, n
        while left <= right:
            mid = (left + right) // 2
            if self.isBadVersion(mid):
                right = mid - 1
            else:
                left = mid + 1
        return left


# Time Complexity: O(log n), where n is the number of versions.
# Space Complexity: O(1), as we are using a constant amount of space.

if __name__ == "__main__":
    solution = FirstBadVersion(4)

    print("Expected Output: 4")
    print("Actual Output:", solution.firstBadVersion(5))

    solution = FirstBadVersion(1)
    print("Expected Output: 1")
    print("Actual Output:", solution.firstBadVersion(1))

    solution = FirstBadVersion(2)
    print("Expected Output: 2")
    print("Actual Output:", solution.firstBadVersion(2))
