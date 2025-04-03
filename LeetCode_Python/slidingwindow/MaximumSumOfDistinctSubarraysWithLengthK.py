class MaximumSumOfDistinctSubarraysWithLengthK:
    def maximumSubarraySum(self, nums: list[int], k: int) -> int:
        n = len(nums)
        if n < k:
            return 0

        max_sum = 0
        current_sum = 0
        freq = {}
        left = 0

        for right in range(n):
            current_sum += nums[right]
            freq[nums[right]] = freq.get(nums[right], 0) + 1

            while freq[nums[right]] > 1:
                current_sum -= nums[left]
                freq[nums[left]] -= 1
                if freq[nums[left]] == 0:
                    del freq[nums[left]]
                left += 1

            if right - left + 1 == k:
                max_sum = max(max_sum, current_sum)
                current_sum -= nums[left]
                freq[nums[left]] -= 1
                if freq[nums[left]] == 0:
                    del freq[nums[left]]
                left += 1

        return max_sum


# Time Complexity: O(n)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = MaximumSumOfDistinctSubarraysWithLengthK()

    print("Expected Output: 15")
    print("Actual Output:", solution.maximumSubarraySum([1, 5, 4, 2, 9, 9, 9], 3))

    print("Expected Output: 0")
    print("Actual Output:", solution.maximumSubarraySum([4, 4, 4], 3))
