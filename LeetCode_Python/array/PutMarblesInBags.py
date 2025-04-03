class PutMarblesInBags:
    def putMarbles(self, weights: list[int], k: int) -> int:
        n = len(weights)
        if k == 1 or k == n:
            return 0

        diffs = []
        for i in range(n - 1):
            diffs.append(weights[i] + weights[i + 1])

        diffs.sort()

        min_sum = sum(diffs[: k - 1])
        max_sum = sum(diffs[-(k - 1) :])

        return max_sum - min_sum


# Time Complexity: O(n log n)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = PutMarblesInBags()

    print("Expected Output: 4")
    print("Actual Output:", solution.putMarbles([1, 3, 5, 1], 2))

    print("Expected Output: 4")
    print("Actual Output:", solution.putMarbles([1, 3, 5, 1], 3))

    print("Expected Output: 0")
    print("Actual Output:", solution.putMarbles([1, 3, 5, 1], 4))
