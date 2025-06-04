class MaximumValueOfKCoinsFromPiles:
    def maxValueOfCoins(self, piles: list[list[int]], k: int) -> int:
        dp = [0] * (k + 1)

        for pile in piles:
            n = len(pile)
            prefix = [0] * (n + 1)

            for i in range(n):
                prefix[i + 1] = prefix[i] + pile[i]

            for i in range(k, -1, -1):
                for j in range(1, min(n, i) + 1):
                    dp[i] = max(dp[i], dp[i - j] + prefix[j])

        return dp[k]


# Time Complexity: O(n * k * m), where n is the number of piles, k is the maximum number of coins, and m is the average size of the piles.
# Space Complexity: O(k), where k is the maximum number of coins.

if __name__ == "__main__":
    solution = MaximumValueOfKCoinsFromPiles()

    print("Expected Output: 15")
    print("Actual Output:", solution.maxValueOfCoins([[1, 2, 3], [4, 5, 6]], 3))

    print("Expected Output: 17")
    print("Actual Output:", solution.maxValueOfCoins([[9, 8, 7], [6, 5, 4]], 2))

    print("Expected Output: 706")
    print(
        "Actual Output:",
        solution.maxValueOfCoins(
            [[100], [100], [100], [100], [100], [100], [1, 1, 1, 1, 1, 1, 700]], 7
        ),
    )
