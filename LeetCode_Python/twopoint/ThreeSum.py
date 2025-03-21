class ThreeSum:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        nums.sort()
        n = len(nums)
        res = []

        for i in range(n - 2):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            left, right = i + 1, n - 1
            while left < right:
                total = nums[i] + nums[left] + nums[right]
                if total < 0:
                    left += 1
                elif total > 0:
                    right -= 1
                else:
                    res.append([nums[i], nums[left], nums[right]])
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1
                    left += 1
                    right -= 1
        return res


# Time Complexity: O(n^2)
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = ThreeSum()

    print("Expected Output: [[-1,-1,2],[-1,0,1]]")
    print("Actual Output:", solution.threeSum([-1, 0, 1, 2, -1, -4]))

    print("Expected Output: []")
    print("Actual Output:", solution.threeSum([0, 1, 1]))

    print("Expected Output: [[0,0,0]]")
    print("Actual Output:", solution.threeSum([0, 0, 0]))
