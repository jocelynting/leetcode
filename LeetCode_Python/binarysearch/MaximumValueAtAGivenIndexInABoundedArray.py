class MaximumValueAtAGivenIndexInABoundedArray:
    def maxValue(self, n: int, index: int, maxSum: int) -> int:
        def calculate(target: int) -> int:
            total = target

            ls = index
            if target > ls:
                ls = (target - 1 + target - ls) * ls // 2
            else:
                ls = (target - 1) * target // 2 + (ls - (target - 1))
            total += ls

            rs = n - index - 1
            if target > rs:
                rs = (target - 1 + target - rs) * rs // 2
            else:
                rs = (target - 1) * target // 2 + (rs - (target - 1))
            total += rs

            return total

        left, right = 1, maxSum
        res = 1

        while left <= right:
            mid = (left + right) // 2
            if calculate(mid) <= maxSum:
                res = mid
                left = mid + 1
            else:
                right = mid - 1

        return res


# Time Complexity: O(log(maxSum)), where maxSum is the maximum sum of the array.
# Space Complexity: O(1), as we are using a constant amount of space.

if __name__ == "__main__":
    solution = MaximumValueAtAGivenIndexInABoundedArray()

    print("Expected Output: 2")
    print("Actual Output:", solution.maxValue(4, 2, 6))

    print("Expected Output: 3")
    print("Actual Output:", solution.maxValue(6, 1, 10))

    print("Expected Output: 2")
    print("Actual Output:", solution.maxValue(6, 1, 8))
