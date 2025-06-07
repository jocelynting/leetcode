class ValidPerfectSquare:
    def isPerfectSquare(self, num: int) -> bool:
        if num < 2:
            return True

        left, right = 2, num // 2 + 1

        while left < right:
            mid = left + (right - left) // 2
            square = mid * mid

            if square < num:
                left = mid + 1
            elif square > num:
                right = mid
            else:
                return True

        return False


# Time Complexity: O(log n), where n is the input number.
# Space Complexity: O(1), as we are using a constant amount of space.

if __name__ == "__main__":
    solution = ValidPerfectSquare()

    print("Expected Output: True")
    print("Actual Output:", solution.isPerfectSquare(16))

    print("Expected Output: False")
    print("Actual Output:", solution.isPerfectSquare(14))

    print("Expected Output: True")
    print("Actual Output:", solution.isPerfectSquare(1))
