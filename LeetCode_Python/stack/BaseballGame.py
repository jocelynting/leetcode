class BaseballGame:
    def calPoints(self, operations: list[str]) -> int:
        stack = []

        for op in operations:
            if op == "+":
                stack.append(stack[-1] + stack[-2])
            elif op == "C":
                stack.pop()
            elif op == "D":
                stack.append(2 * stack[-1])
            else:
                stack.append(int(op))

        return sum(stack)


if __name__ == "__main__":
    solution = BaseballGame()

    print("Expected Output: 30")
    print("Actual Output:", solution.calPoints(["5", "2", "C", "D", "+"]))

    print("Expected Output: 27")
    print(
        "Actual Output:", solution.calPoints(["5", "-2", "4", "C", "D", "9", "+", "+"])
    )

    print("Expected Output: 1")
    print("Actual Output:", solution.calPoints(["1"]))
