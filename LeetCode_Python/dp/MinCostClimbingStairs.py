class MinCostClimbingStairs:
    def minCostClimbingStairs(self, cost: list[int]) -> int:
        n = len(cost)
        dp = [0] * (n + 1)

        for i in range(2, n + 1):
            dp[i] = min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])

        return dp[-1]

    # Time Complexity: O(n), where n is the number of steps
    # Space Complexity: O(n), for the dp array

    def minCostClimbingStairs_optimized(self, cost: list[int]) -> int:
        n = len(cost)

        first = second = 0

        for i in range(2, n + 1):
            c = min(first + cost[i - 2], second + cost[i - 1])
            first, second = second, c

        return second

    # Time Complexity: O(n), where n is the number of steps
    # Space Complexity: O(1), using only two variables to store previous states


if __name__ == "__main__":
    solution = MinCostClimbingStairs()
    cost1 = [10, 15, 20]
    print("Expected Output: 15")
    print("Actual Output:", solution.minCostClimbingStairs(cost1))
    print("Actual Output:", solution.minCostClimbingStairs_optimized(cost1))

    cost2 = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
    print("Expected Output: 6")
    print("Actual Output:", solution.minCostClimbingStairs(cost2))
    print("Actual Output:", solution.minCostClimbingStairs_optimized(cost2))
