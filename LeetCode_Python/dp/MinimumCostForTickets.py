class MinimumCostForTickets:
    def mincostTickets(self, days, costs):
        last = days[-1]
        days = set(days)
        dp = [0] * (last + 1)

        for i in range(1, len(dp)):
            if i not in days:
                dp[i] = dp[i - 1]
            else:
                dp[i] = min(
                    dp[i - 1] + costs[0],
                    dp[max(0, i - 7)] + costs[1],
                    dp[max(0, i - 30)] + costs[2],
                )

        return dp[-1]


# Time Complexity: O(n), where n is the last day in the days list
# Space Complexity: O(n), for the dp array

if __name__ == "__main__":
    solution = MinimumCostForTickets()

    days1 = [1, 4, 6, 7, 8, 20]
    costs1 = [2, 7, 15]
    print("Expected Output: 11")
    print("Actual Output:", solution.mincostTickets(days1, costs1))

    days2 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31]
    costs2 = [2, 7, 15]
    print("Expected Output: 17")
    print("Actual Output:", solution.mincostTickets(days2, costs2))
