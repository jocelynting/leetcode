class FibonacciNumber:
    def fib(self, n: int) -> int:
        if n < 2:
            return n

        dp = [0] * (n + 1)
        dp[0] = 0
        dp[1] = 1

        for i in range(2, n + 1):
            dp[i] = dp[i - 1] + dp[i - 2]

        return dp[n]


if __name__ == "__main__":
    solution = FibonacciNumber()

    print("Expected Output : 1")
    print("Actual Output : ", solution.fib(2))

    print("Expected Output : 2")
    print("Actual Output : ", solution.fib(3))

    print("Expected Output : 3")
    print("Actual Output : ", solution.fib(4))
