class BasicCalculator:
    def calculate(self, s: str) -> int:
        stack = []
        res = 0
        sign = 1
        i, n = 0, len(s)

        while i < n:
            char = s[i]
            if char.isdigit():
                num = 0
                while i < n and s[i].isdigit():
                    num = num * 10 + int(s[i])
                    i += 1
                res += num * sign
                continue
            elif char == "+":
                sign = 1
            elif char == "-":
                sign = -1
            elif char == "(":
                stack.append(res)
                stack.append(sign)
                res = 0
                sign = 1
            elif char == ")":
                res *= stack.pop()
                res += stack.pop()
            i += 1
        return res


# Time Complexity: O(n)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = BasicCalculator()

    print("Expected Output : 2")
    print("Actual Output   :", solution.calculate("1 + 1"))

    print("Expected Output : 3")
    print("Actual Output   :", solution.calculate("2-1 + 2"))

    print("Expected Output : 23")
    print("Actual Output   :", solution.calculate("(1+(4+5+2)-3)+(6+8)"))
