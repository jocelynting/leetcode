class ReverseInteger:
    def reverse(self, x: int) -> int:
        sign = 1 if x > 0 else -1
        x = abs(x)
        res = 0

        while x:
            res = res * 10 + x % 10
            x //= 10

        res *= sign

        if res < -(2**31) or res > 2**31 - 1:
            return 0

        return res


if __name__ == "__main__":
    solution = ReverseInteger()

    print("Expected Output : 321")
    print("Actual Output : ", solution.reverse(123))

    print("Expected Output : -321")
    print("Actual Output : ", solution.reverse(-123))

    print("Expected Output : 21")
    print("Actual Output : ", solution.reverse(120))
