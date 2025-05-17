class CountOddNumbersInAnIntervalRange:
    def countOdds(self, low: int, high: int) -> int:
        return (high + 1) // 2 - low // 2


# Time Complexity: O(1), constant time complexity
# Space Complexity: O(1), no extra space is used

if __name__ == "__main__":
    solution = CountOddNumbersInAnIntervalRange()

    print("Expected Output: 3")
    print("Actual Output: ", solution.countOdds(3, 7))

    print("Expected Output: 1")
    print("Actual Output: ", solution.countOdds(8, 10))

    print("Expected Output: 0")
    print("Actual Output: ", solution.countOdds(0, 0))
