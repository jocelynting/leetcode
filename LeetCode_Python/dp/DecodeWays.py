class DecodeWays:
    def numDecodings(self, s: str) -> int:
        n = len(s)
        dp = [0] * (n + 1)
        dp[0] = 1
        dp[1] = 1 if s[0] != "0" else 0

        for i in range(2, n + 1):
            one = int(s[i - 1])
            if 0 < one <= 9:
                dp[i] += dp[i - 1]

            two = int(s[i - 2 : i])
            if 10 <= two <= 26:
                dp[i] += dp[i - 2]

        return dp[n]


# Time Complexity: O(n)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = DecodeWays()

    print("Expected Output: 2")
    print("Actual Output:", solution.numDecodings("12"))

    print("Expected Output: 3")
    print("Actual Output:", solution.numDecodings("226"))

    print("Expected Output: 0")
    print("Actual Output:", solution.numDecodings("0"))
