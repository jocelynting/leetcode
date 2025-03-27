class SingleNumber:
    def singleNumber(self, nums: list[int]) -> int:
        res = 0
        for num in nums:
            res ^= num
        return res


# Time Complexity: O(n)
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = SingleNumber()

    nums1 = [2, 2, 1]
    print("Expected Output: 1")
    print("Actual Output:", solution.singleNumber(nums1))

    nums2 = [4, 1, 2, 1, 2]
    print("Expected Output: 4")
    print("Actual Output:", solution.singleNumber(nums2))

    nums3 = [1]
    print("Expected Output: 1")
    print("Actual Output:", solution.singleNumber(nums3))
