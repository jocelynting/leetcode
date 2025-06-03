class PaintHouseII:
    def minCostII(self, costs: list[list[int]]) -> int:
        n, k = len(costs), len(costs[0])

        prev = [0] * k

        for i in range(n):
            cur = [0] * k
            min1 = min2 = float("inf")
            color1 = color2 = -1

            for j in range(k):
                cost = prev[j]
                if cost < min1:
                    min2 = min1
                    color2 = color1
                    min1 = cost
                    color1 = j
                elif cost < min2:
                    min2 = cost
                    color2 = j

            for j in range(k):
                if j == color1:
                    cur[j] = min2 + costs[i][j]
                else:
                    cur[j] = min1 + costs[i][j]

            prev = cur

        return min(prev)


# Time Complexity: O(n * k), where n is the number of houses and k is the number of colors
# Space Complexity: O(k), for the previous row of costs

if __name__ == "__main__":
    solution = PaintHouseII()

    costs1 = [[1, 5, 3], [2, 9, 4]]
    print("Expected Output: 5")
    print("Actual Output:", solution.minCostII(costs1))

    costs2 = [[1, 3], [2, 4]]
    print("Expected Output: 5")
    print("Actual Output:", solution.minCostII(costs2))

    costs3 = [[7, 8, 9], [5, 6, 4], [3, 2, 1]]
    print("Expected Output: 13")
    print("Actual Output:", solution.minCostII(costs3))
