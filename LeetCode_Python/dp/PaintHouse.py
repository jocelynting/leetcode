class PaintHouse:
    def minCost(self, costs: list[list[int]]) -> int:
        n = len(costs)
        dp = [[0] * 3 for _ in range(n)]
        dp[0] = costs[0]

        for i in range(1, n):
            dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0]
            dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1]
            dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2]

        return min(dp[-1])

    # Time Complexity: O(n), where n is the number of houses
    # Space Complexity: O(n), for the dp array

    def minCostOptimized(self, costs: list[list[int]]) -> int:
        n = len(costs)
        prev = costs[0]

        for i in range(1, n):
            cur = [0] * 3
            cur[0] = min(prev[1], prev[2]) + costs[i][0]
            cur[1] = min(prev[0], prev[2]) + costs[i][1]
            cur[2] = min(prev[0], prev[1]) + costs[i][2]
            prev = cur

        return min(prev)

    # Time Complexity: O(n), where n is the number of houses
    # Space Complexity: O(1), using only a constant amount of space for the previous row


if __name__ == "__main__":
    solution = PaintHouse()

    costs1 = [[17, 2, 17], [16, 16, 5], [14, 3, 19]]
    print("Expected Output: 10")
    print("Actual Output:", solution.minCost(costs1))
    print("Actual Output:", solution.minCostOptimized(costs1))

    costs2 = [[7, 6, 2]]
    print("Expected Output: 2")
    print("Actual Output:", solution.minCost(costs2))
    print("Actual Output:", solution.minCostOptimized(costs2))
