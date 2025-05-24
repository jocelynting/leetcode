class DeleteAndEarn:
    def deleteAndEarn(self, nums: list[int]) -> int:
        if not nums:
            return 0

        max_num = max(nums)
        points = [0] * (max_num + 1)

        for num in nums:
            points[num] += num

        prev, curr = points[0], max(points[0], points[1])

        for i in range(2, len(points)):
            prev, curr = curr, max(curr, prev + points[i])

        return curr

    # Time Complexity: O(n + m), where n is the length of nums and m is the maximum number in nums
    # Space Complexity: O(m), for the points array

    def deleteAndEarnByDPArray(self, nums: list[int]) -> int:
        if not nums:
            return 0

        max_num = max(nums)
        points = [0] * (max_num + 1)

        for num in nums:
            points[num] += num

        dp = [0] * (max_num + 1)
        dp[0] = points[0]
        dp[1] = max(points[0], points[1])

        for i in range(2, max_num + 1):
            dp[i] = max(dp[i - 1], dp[i - 2] + points[i])

        return dp[max_num]

    # Time Complexity: O(n + m), where n is the length of nums and m is the maximum number in nums
    # Space Complexity: O(m), for the points array and dp array


if __name__ == "__main__":
    solution = DeleteAndEarn()

    nums1 = [3, 4, 2]
    print("Expected Output: 6")
    print("Actual Output:", solution.deleteAndEarn(nums1))
    print("Actual Output:", solution.deleteAndEarnByDPArray(nums1))

    nums2 = [2, 2, 3, 3, 3, 4]
    print("Expected Output: 9")
    print("Actual Output:", solution.deleteAndEarn(nums2))
    print("Actual Output:", solution.deleteAndEarnByDPArray(nums2))

    nums3 = [1, 1, 1, 2, 2, 3]
    print("Expected Output: 6")
    print("Actual Output:", solution.deleteAndEarn(nums3))
    print("Actual Output:", solution.deleteAndEarnByDPArray(nums3))
