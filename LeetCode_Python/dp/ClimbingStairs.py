class ClimbingStairs:
    def climbStairs(self, n: int) -> int:
        if n <= 2:
            return n

        first = 1
        second = 2

        for i in range(3, n + 1):
            third = first + second
            first = second
            second = third

        return second

    # Time Complexity: O(n)
    # Space Complexity: O(1)

    def climbStairsByDPArray(self, n: int) -> int:
        if n <= 2:
            return n

        dp = [0] * (n + 1)
        dp[1] = 1
        dp[2] = 2

        for i in range(3, n + 1):
            dp[i] = dp[i - 1] + dp[i - 2]

        return dp[n]

    # Time Complexity: O(n)
    # Space Complexity: O(n)


if __name__ == "__main__":
    solution = ClimbingStairs()

    print("Expected Output : 2")
    print("Actual Output : ", solution.climbStairs(2))
    print("Actual Output : ", solution.climbStairsByDPArray(2))

    print("Expected Output : 3")
    print("Actual Output : ", solution.climbStairs(3))
    print("Actual Output : ", solution.climbStairsByDPArray(3))
