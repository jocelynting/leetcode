class BasicCalculatorII:
    def calculate(self, s: str) -> int:
        stack = []
        num = 0
        operator = "+"

        for i in range(len(s)):
            char = s[i]
            if char.isdigit():
                num = num * 10 + int(char)
            if char in "+-*/" or i == len(s) - 1:
                if operator == "+":
                    stack.append(num)
                elif operator == "-":
                    stack.append(-num)
                elif operator == "*":
                    stack.append(stack.pop() * num)
                elif operator == "/":
                    stack.append(int(stack.pop() / num))
                operator = char
                num = 0
        return sum(stack)


# Time Complexity: O(n)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = BasicCalculatorII()

    print("Expected Output : 7")
    print("Actual Output   :", solution.calculate("3+2*2"))

    print("Expected Output : 1")
    print("Actual Output   :", solution.calculate("3/2"))

    print("Expected Output : 5")
    print("Actual Output   :", solution.calculate("3+5/2"))

    print("Expected Output : 3")
    print("Actual Output   :", solution.calculate("3"))
