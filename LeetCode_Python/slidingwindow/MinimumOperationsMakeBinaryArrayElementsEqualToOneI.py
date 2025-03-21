class MinimumOperationsMakeBinaryArrayElementsEqualToOneI:
    def minOperations(self, nums: list[int]) -> int:
        n = len(nums)
        res = 0

        for i in range(2, n):
            if nums[i - 2] == 0:
                res += 1
                nums[i - 2] = nums[i - 2] ^ 1
                nums[i - 1] = nums[i - 1] ^ 1
                nums[i] = nums[i] ^ 1

        return res if sum(nums) == len(nums) else -1


# Time Complexity: O(n)
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = MinimumOperationsMakeBinaryArrayElementsEqualToOneI()

    print("Expected Output: 3")
    print("Actual Output:", solution.minOperations([0, 1, 1, 1, 0, 0]))

    print("Expected Output: -1")
    print("Actual Output:", solution.minOperations([0, 1, 1, 1]))
