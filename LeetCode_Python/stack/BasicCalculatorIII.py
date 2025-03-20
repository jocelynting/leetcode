from typing import Union


class BasicCalculatorIII:
    def calculate(self, s: str) -> int:
        def helper(s: str, i: int) -> Union[int, int]:
            stack = []
            num = 0
            operator = "+"
            while i < len(s):
                char = s[i]
                if char.isdigit():
                    num = num * 10 + int(char)
                if char == "(":
                    num, i = helper(s, i + 1)
                if (not char.isdigit() and char != " ") or i == len(s) - 1:
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
                if char == ")":
                    return sum(stack), i
                i += 1
            return sum(stack), i

        res, _ = helper(s, 0)
        return res


# Time Complexity: O(n)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = BasicCalculatorIII()

    print("Expected Output : 7")
    print("Actual Output   :", solution.calculate("3+2*2"))

    print("Expected Output : 1")
    print("Actual Output   :", solution.calculate("3/2"))

    print("Expected Output : 5")
    print("Actual Output   :", solution.calculate("3+5/2"))

    print("Expected Output : 21")
    print("Actual Output   :", solution.calculate("2*(5+5*2)/3+(6/2+8)"))
