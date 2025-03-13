class ValidParenthesisString:
    def checkValidString(self, s: str) -> bool:
        left_stack = []
        star_stack = []

        for i, ch in enumerate(s):
            if ch == "(":
                left_stack.append(i)
            elif ch == "*":
                star_stack.append(i)
            else:
                if left_stack:
                    left_stack.pop()
                elif star_stack:
                    star_stack.pop()
                else:
                    return False

        while left_stack and star_stack:
            if left_stack[-1] < star_stack[-1]:
                left_stack.pop()
                star_stack.pop()
            else:
                return False

        return not left_stack


if __name__ == "__main__":
    solution = ValidParenthesisString()

    print("Expected Output: True")
    print("Actual Output:", solution.checkValidString("()"))

    print("Expected Output: True")
    print("Actual Output:", solution.checkValidString("(*)"))

    print("Expected Output: True")
    print("Actual Output:", solution.checkValidString("(*))"))

    print("Expected Output: False")
    print("Actual Output:", solution.checkValidString("(*)))"))
