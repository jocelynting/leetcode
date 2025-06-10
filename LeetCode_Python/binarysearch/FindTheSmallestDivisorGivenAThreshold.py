import math


class FindTheSmallestDivisorGivenAThreshold:
    def smallestDivisor(self, nums: list[int], threshold: int) -> int:
        def calculate(target: int) -> int:
            total = 0
            for num in nums:
                total += math.ceil(num / target)
            return total

        left, right = 1, max(nums)

        while left < right:
            mid = (left + right) // 2
            if calculate(mid) > threshold:
                left = mid + 1
            else:
                right = mid

        return left


# Time Complexity: O(n log(max(nums))), where n is the length of nums and max(nums) is the maximum value in nums.
# Space Complexity: O(1), as we are using a constant amount of space for variables.

if __name__ == "__main__":
    solution = FindTheSmallestDivisorGivenAThreshold()

    print("Expected Output: 5")
    print("Actual Output:", solution.smallestDivisor([1, 2, 5, 9], 6))

    print("Expected Output: 3")
    print("Actual Output:", solution.smallestDivisor([2, 3, 5, 7, 11], 11))

    print("Expected Output: 4")
    print("Actual Output:", solution.smallestDivisor([19], 5))
