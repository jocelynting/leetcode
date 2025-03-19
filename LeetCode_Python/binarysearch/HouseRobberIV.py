class HouseRobberIV:
    def minCapability(self, nums: list[int], k: int) -> int:
        n = len(nums)

        def canRob(capabilty: int) -> bool:
            i = 0
            count = 0
            while i < n:
                if nums[i] <= capabilty:
                    count += 1
                    i += 2
                else:
                    i += 1
            return count >= k

        left, right = min(nums), max(nums)
        res = 0
        while left <= right:
            mid = left + (right - left) // 2
            if canRob(mid):
                res = mid
                right = mid - 1
            else:
                left = mid + 1
        return res


if __name__ == "__main__":
    solution = HouseRobberIV()

    print("Expected Output : 5")
    print("Actual Output :", solution.minCapability([2, 3, 5, 9], 2))

    print("Expected Output : 2")
    print("Actual Output :", solution.minCapability([2, 7, 9, 3, 1], 2))
