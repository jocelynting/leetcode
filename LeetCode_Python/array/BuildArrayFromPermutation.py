class BuildArrayFromPermutation:
    def buildArray(self, nums: list[int]) -> list[int]:
        n = len(nums)

        for i in range(n):
            nums[i] = nums[i] + (nums[nums[i]] % n) * n

        for i in range(n):
            nums[i] = nums[i] // n

        return nums


# Time Complexity: O(n), where n is the length of the input array nums.
# Space Complexity: O(1), as we are modifying the input array in place.

if __name__ == "__main__":
    solution = BuildArrayFromPermutation()

    print("Expected Output: [0, 1, 2, 4, 5, 3]")
    print("Actual Output: ", solution.buildArray([0, 2, 1, 5, 3, 4]))

    print("Expected Output: [4, 5, 0, 1, 2, 3]")
    print("Actual Output: ", solution.buildArray([5, 0, 1, 2, 3, 4]))
