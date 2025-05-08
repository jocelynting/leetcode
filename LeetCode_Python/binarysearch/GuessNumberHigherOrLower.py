class GuessNumberHigherOrLower:
    def guess(self, num: int) -> int:
        if num == 6:
            return 0
        elif num > 6:
            return -1
        else:
            return 1

    def guessNumber(self, n: int) -> int:
        left, right = 1, n
        while left <= right:
            mid = left + (right - left) // 2
            if self.guess(mid) == -1:
                right = mid - 1
            elif self.guess(mid) == 1:
                left = mid + 1
            else:
                return mid

        return -1


# Time Complexity: O(log n), as we are halving the search space in each iteration
# Space Complexity: O(1), as we are using a constant amount of space

if __name__ == "__main__":
    solution = GuessNumberHigherOrLower()

    print("Expected Output: 6")
    print("Actual Output:", solution.guessNumber(10))
