class ValidParenthesisString:
    def checkValidString(self, s: str) -> bool:
        left, right = 0, 0

        for ch in s:
            if ch == "(":
                left += 1
                right += 1
            elif ch == ")":
                left -= 1
                right -= 1
            else:
                left -= 1
                right += 1

            if right < 0:
                return False

            # left 不能为负数，表示最坏情况下开放括号至少为 0
            if left < 0:
                left = 0

        return left == 0


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
