class ArrayPartition:
    def arrayPairSum(self, nums: list[int]) -> int:
        nums.sort()
        res = 0

        for i in range(0, len(nums), 2):
            res += nums[i]

        return res


# Time Complexity: O(nlogn)
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = ArrayPartition()

    print("Expected Output: 4")
    print("Actual Output:", solution.arrayPairSum([1, 4, 3, 2]))

    print("Expected Output: 9")
    print("Actual Output:", solution.arrayPairSum([6, 2, 6, 5, 1, 2]))
