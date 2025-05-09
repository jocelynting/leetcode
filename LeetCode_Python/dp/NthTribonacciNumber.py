class NthTribonacciNumber:
    def tribonacci(self, n: int) -> int:
        if n == 0:
            return 0
        elif n == 1 or n == 2:
            return 1

        dp = [0] * (n + 1)
        dp[0], dp[1], dp[2] = 0, 1, 1

        for i in range(3, n + 1):
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]

        return dp[n]


# Time Complexity: O(n), where n is the input number
# Space Complexity: O(n), for the dp array

if __name__ == "__main__":
    solution = NthTribonacciNumber()

    print("Expected Output: 4")
    print("Actual Output:", solution.tribonacci(4))

    print("Expected Output: 1389537")
    print("Actual Output:", solution.tribonacci(25))
