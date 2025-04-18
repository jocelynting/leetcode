from functools import cache


class PredictTheWinner:
    def predictTheWinner(self, nums: list[int]) -> bool:

        @cache
        def dp(i: int, j: int) -> int:
            if i == j:
                return nums[i]
            return max(nums[i] - dp(i + 1, j), nums[j] - dp(i, j - 1))

        return dp(0, len(nums) - 1) >= 0


# Time Complexity: O(n^2)
# Space Complexity: O(n^2) for the memoization cache

if __name__ == "__main__":
    solution = PredictTheWinner()

    nums1 = [1, 5, 2]
    print("Expected Output: ", False)
    print("Actual Output: ", solution.predictTheWinner(nums1))

    nums2 = [1, 5, 233, 7]
    print("Expected Output: ", True)
    print("Actual Output: ", solution.predictTheWinner(nums2))
