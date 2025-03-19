class EvaluateReversePolishNotation:
    def evalRPN(self, tokens: list[str]) -> int:
        stack = []

        for token in tokens:
            if token in ["+", "-", "*", "/"]:
                num2 = stack.pop()
                num1 = stack.pop()
                if token == "+":
                    stack.append(num1 + num2)
                elif token == "-":
                    stack.append(num1 - num2)
                elif token == "*":
                    stack.append(num1 * num2)
                else:
                    stack.append(int(num1 / num2))
            else:
                stack.append(int(token))
        return stack[0]


# Time Complexity: O(n)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = EvaluateReversePolishNotation()

    print("Expected Output : 9")
    print("Actual Output   :", solution.evalRPN(["2", "1", "+", "3", "*"]))

    print("Expected Output : 6")
    print("Actual Output   :", solution.evalRPN(["4", "13", "5", "/", "+"]))

    print("Expected Output : 22")
    print(
        "Actual Output   :",
        solution.evalRPN(
            ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
        ),
    )
