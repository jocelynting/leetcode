class CountingBits:
    def countBits(self, n: int) -> list[int]:
        dp = [0] * (n + 1)
        dp[0] = 0

        for i in range(1, n + 1):
            dp[i] = dp[i >> 1] + (i & 1)

        return dp


# Time Complexity: O(n), where n is the input number.
# Space Complexity: O(n), for the dp array.

if __name__ == "__main__":
    solution = CountingBits()

    print("Expected Output: [0, 1, 1, 2, 1, 2, 2, 3]")
    print("Actual Output: ", solution.countBits(7))

    print("Expected Output: [0, 1, 1, 2, 1, 2, 2, 3, 1, 2]")
    print("Actual Output: ", solution.countBits(9))
