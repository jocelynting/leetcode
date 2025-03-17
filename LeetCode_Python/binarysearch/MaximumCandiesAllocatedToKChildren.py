class MaximumCandiesAllocatedToKChildren:
    def maximumCandies(self, candies: list[int], k: int) -> int:
        left, right = 1, max(candies) + 1
        res = 0

        while left < right:
            mid = left + (right - left) // 2
            count = sum(c // mid for c in candies)

            if count >= k:
                res = mid
                left = mid + 1
            else:
                right = mid

        return res


if __name__ == "__main__":
    solution = MaximumCandiesAllocatedToKChildren()

    print("Expected Output: 5")
    print("Actual Output:", solution.maximumCandies([5, 8, 6], 3))

    print("Expected Output: 0")
    print("Actual Output:", solution.maximumCandies([2, 5], 11))
