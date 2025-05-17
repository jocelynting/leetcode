class LargestPerimeterTriangle:
    def largestPerimeter(self, nums: list[int]) -> int:
        nums.sort()

        for i in range(len(nums) - 3, -1, -1):
            if nums[i] + nums[i + 1] > nums[i + 2]:
                return nums[i] + nums[i + 1] + nums[i + 2]

        return 0


# Time Complexity: O(n log n), where n is the length of the nums array
# Space Complexity: O(1), no extra space is used

if __name__ == "__main__":
    solution = LargestPerimeterTriangle()

    print("Expected Output: 5")
    print("Actual Output: ", solution.largestPerimeter([2, 1, 2]))

    print("Expected Output: 0")
    print("Actual Output: ", solution.largestPerimeter([1, 2, 1]))

    print("Expected Output: 10")
    print("Actual Output: ", solution.largestPerimeter([3, 2, 3, 4]))
