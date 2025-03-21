class FourSum:
    def fourSum(self, nums: list[int], target: int) -> list[list[int]]:
        nums.sort()
        n = len(nums)
        res = []

        for i in range(n - 3):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            for j in range(i + 1, n - 2):
                if j > i + 1 and nums[j] == nums[j - 1]:
                    continue
                left, right = j + 1, n - 1
                while left < right:
                    total = nums[i] + nums[j] + nums[left] + nums[right]
                    if total < target:
                        left += 1
                    elif total > target:
                        right -= 1
                    else:
                        res.append([nums[i], nums[j], nums[left], nums[right]])
                        while left < right and nums[left] == nums[left + 1]:
                            left += 1
                        while left < right and nums[right] == nums[right - 1]:
                            right -= 1
                        left += 1
                        right -= 1

        return res


# Time Complexity: O(n^3)
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = FourSum()

    print("Expected Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]")
    print("Actual Output:", solution.fourSum([1, 0, -1, 0, -2, 2], 0))

    print("Expected Output: [2,2,2,2]")
    print("Actual Output:", solution.fourSum([2, 2, 2, 2, 2], 8))
