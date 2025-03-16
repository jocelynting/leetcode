class AddBinary:
    def addBinary(self, a: str, b: str) -> str:
        carry = 0
        i = len(a) - 1
        j = len(b) - 1
        res = []

        while i >= 0 or j >= 0 or carry:
            total = carry
            if i >= 0:
                total += int(a[i])
                i -= 1
            if j >= 0:
                total += int(b[j])
                j -= 1

            res.append(str(total % 2))
            carry = total // 2

        return "".join(res[::-1])

    def addBinary2(self, a: str, b: str) -> str:
        return bin(int(a, 2) + int(b, 2))[2:]


if __name__ == "__main__":
    solution = AddBinary()

    print("Expected Output: 100")
    print("Actual Output:", solution.addBinary("11", "1"))
    print("Actual Output:", solution.addBinary2("11", "1"))

    print("Expected Output: 10101")
    print("Actual Output:", solution.addBinary("1010", "1011"))
    print("Actual Output:", solution.addBinary2("1010", "1011"))
