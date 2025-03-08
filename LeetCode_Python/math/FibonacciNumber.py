class FibonacciNumber:
    def fib(self, n: int) -> int:
        if n == 0:
            return 0
        if n == 1:
            return 1

        a, b = 0, 1
        for _ in range(2, n + 1):
            a, b = b, a + b
        return b


if __name__ == "__main__":
    solution = FibonacciNumber()

    print("Expected Output : 1")
    print("Actual Output : ", solution.fib(2))

    print("Expected Output : 2")
    print("Actual Output : ", solution.fib(3))

    print("Expected Output : 3")
    print("Actual Output : ", solution.fib(4))
