class HIndexII:
    def hIndex(self, cite: list[int]) -> int:
        n = len(cite)
        left, right = 0, n

        while left < right:
            mid = left + (right - left) // 2

            if cite[mid] < n - mid:
                left = mid + 1
            else:
                right = mid

        return n - left


# Time Complexity: O(log n), where n is the number of citations.
# Space Complexity: O(1), as we are using a constant amount of space.

if __name__ == "__main__":
    solution = HIndexII()

    print("Expected Output: 3")
    print("Actual Output:", solution.hIndex([0, 1, 3, 5, 6]))

    print("Expected Output: 1")
    print("Actual Output:", solution.hIndex([1]))

    print("Expected Output: 2")
    print("Actual Output:", solution.hIndex([1, 2, 100]))
