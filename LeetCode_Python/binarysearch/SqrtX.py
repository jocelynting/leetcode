class SqrtX:
    def mySqrt(self, x: int) -> int:
        if x < 2:
            return x

        left, right = 2, x // 2

        while left <= right:
            mid = left + (right - left) // 2
            num = mid * mid
            if num < x:
                left = mid + 1
            elif num > x:
                right = mid - 1
            else:
                return mid

        # When the loop ends, left is greater than right.
        # The largest integer whose square is less than or equal to x is right.
        # This is because left will be the first number whose square is greater than x.
        return right


# Time Complexity: O(log n), where n is the input number x. The binary search reduces the search space by half in each iteration.
# Space Complexity: O(1), as we are using a constant amount of space for variables.

if __name__ == "__main__":
    solution = SqrtX()

    print("Expected Output: 2")
    print("Actual Output:", solution.mySqrt(8))

    print("Expected Output: 4")
    print("Actual Output:", solution.mySqrt(16))
