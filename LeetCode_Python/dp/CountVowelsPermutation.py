class CountVowelsPermutation:
    def countVowelPermutation(self, n: int) -> int:
        mod = 10**9 + 7
        dp = [[0] * 5 for _ in range(n + 1)]

        dp[1] = [1, 1, 1, 1, 1]

        for i in range(2, n + 1):
            dp[i][0] += dp[i - 1][1] % mod
            dp[i][1] += (dp[i - 1][0] + dp[i - 1][2]) % mod
            dp[i][2] += (
                dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][4]
            ) % mod
            dp[i][3] += (dp[i - 1][2] + dp[i - 1][4]) % mod
            dp[i][4] += dp[i - 1][0] % mod

        return sum(dp[-1]) % mod

    # Time Complexity: O(n), where n is the length of the string
    # Space Complexity: O(n), for the dp array

    def countVowelPermutationOptimized(self, n: int) -> int:
        mod = 10**9 + 7
        c1 = c2 = c3 = c4 = c5 = 1

        for _ in range(1, n):
            nc1 = c2 % mod
            nc2 = (c1 + c3) % mod
            nc3 = (c1 + c2 + c4 + c5) % mod
            nc4 = (c3 + c5) % mod
            nc5 = c1 % mod
            c1, c2, c3, c4, c5 = nc1, nc2, nc3, nc4, nc5

        return (c1 + c2 + c3 + c4 + c5) % mod

    # Time Complexity: O(n), where n is the length of the string
    # Space Complexity: O(1), using a fixed-size array for dp


if __name__ == "__main__":
    solution = CountVowelsPermutation()

    print("Expected Output: 5")
    print("Actual Output:", solution.countVowelPermutation(1))
    print("Actual Output:", solution.countVowelPermutationOptimized(1))

    print("Expected Output: 10")
    print("Actual Output:", solution.countVowelPermutation(2))
    print("Actual Output:", solution.countVowelPermutationOptimized(2))

    print("Expected Output: 68")
    print("Actual Output:", solution.countVowelPermutation(5))
    print("Actual Output:", solution.countVowelPermutationOptimized(5))
