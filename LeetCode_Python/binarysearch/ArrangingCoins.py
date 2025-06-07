class ArrangingCoins:
    def arrangeCoins(self, n: int) -> int:
        left, right = 0, n
        while left <= right:
            mid = left + (right - left) // 2
            total = mid * (mid + 1) // 2

            if total <= n:
                left = mid + 1
            else:
                right = mid - 1

        return right


# Time Complexity: O(log n), where n is the number of coins.
# Space Complexity: O(1), as we are using a constant amount of space.

if __name__ == "__main__":
    solution = ArrangingCoins()

    print("Expected Output: 4")
    print("Actual Output:", solution.arrangeCoins(14))

    print("Expected Output: 2")
    print("Actual Output:", solution.arrangeCoins(5))

    print("Expected Output: 3")
    print("Actual Output:", solution.arrangeCoins(8))
