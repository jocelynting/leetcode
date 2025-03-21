class JumpGame:
    def canJump(self, nums: list[int]) -> bool:
        n = len(nums)
        fastest = 0

        for i in range(n):
            if i > fastest:
                return False
            fastest = max(fastest, i + nums[i])
            if fastest >= n - 1:
                return True
        return False


# Time Complexity: O(n)
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = JumpGame()

    print("Expeted Output : True")
    print("Actual Output : ", solution.canJump([2, 3, 1, 1, 4]))

    print("Expeted Output : False")
    print("Actual Output : ", solution.canJump([3, 2, 1, 0, 4]))
