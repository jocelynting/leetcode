class PowXN:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1 / x
            n = -n

        res = 1
        cur = x

        while n > 0:
            if n % 2 == 1:
                res *= cur
            cur *= cur
            n //= 2

        return res

    def myPowByRecursion(self, x: float, n: int) -> float:

        def fastPow(x: float, n: int) -> float:
            if n == 0:
                return 1
            half = fastPow(x, n // 2)
            if n % 2 == 0:
                return half * half
            else:
                return half * half * x

        if n < 0:
            x = 1 / x
            n = -n
        return fastPow(x, n)


if __name__ == "__main__":
    solution = PowXN()

    print("Expected Output: 1024.00000")
    print("Actual Output:", solution.myPow(2.00000, 10))
    print("Actual Output:", solution.myPowByRecursion(2.00000, 10))

    print("Expected Output: 9.26100")
    print("Actual Output:", solution.myPow(2.10000, 3))
    print("Actual Output:", solution.myPowByRecursion(2.10000, 3))

    print("Expected Output: 0.25000")
    print("Actual Output:", solution.myPow(2.00000, -2))
    print("Actual Output:", solution.myPowByRecursion(2.00000, -2))
