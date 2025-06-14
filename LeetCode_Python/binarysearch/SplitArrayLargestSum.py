class SplitArrayLargestSum:
    def splitArray(self, nums: list[int], k: int) -> int:
        def calculate(target: int) -> int:
            total, count = 0, 0

            for n in nums:
                total += n
                if total > target:
                    count += 1
                    total = n

            if total > 0:
                count += 1

            return count

        left, right = max(nums), sum(nums)

        while left < right:
            mid = left + (right - left) // 2
            if calculate(mid) > k:
                left = mid + 1
            else:
                right = mid

        return left


# Time Complexity: O(n log(sum(nums))), where n is the length of the nums array.
# This is because we perform a binary search on the range from max(nums) to sum(nums),
# and for each mid value, we iterate through the nums array to calculate the number of subarrays.
# Space Complexity: O(1), as we are using a constant amount of space for variables.

if __name__ == "__main__":
    solution = SplitArrayLargestSum()

    print("Expected Output: 18")
    print("Actual Output:", solution.splitArray([7, 2, 5, 10, 8], 2))

    print("Expected Output: 9")
    print("Actual Output:", solution.splitArray([1, 2, 3, 4, 5], 2))

    print("Expected Output: 4")
    print("Actual Output:", solution.splitArray([1, 4, 4], 3))
