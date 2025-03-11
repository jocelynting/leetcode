class FrequencyOfTheMostFrequentElement:
    def maxFrequency(self, nums: list[int], k: int) -> int:
        nums.sort()
        left = right = 0
        total = 0
        res = 0

        while right < len(nums):
            total += nums[right]

            while nums[right] * (right - left + 1) - total > k:
                total -= nums[left]
                left += 1

            res = max(res, right - left + 1)

            right += 1

        return res


if __name__ == "__main__":
    solution = FrequencyOfTheMostFrequentElement()

    nums = [1, 2, 4]
    k = 5
    print("Expected Output : 3")
    print("Actual Output : " + str(solution.maxFrequency(nums, k)))

    nums = [1, 4, 8, 13]
    k = 5
    print("Expected Output : 2")
    print("Actual Output : " + str(solution.maxFrequency(nums, k)))
