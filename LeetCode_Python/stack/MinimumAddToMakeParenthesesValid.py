class MinimumAddToMakeParenthesesValid:
    def minAddToMakeValid(self, s: str) -> int:
        stack = []
        res = 0

        for char in s:
            if char == "(":
                stack.append(char)
            else:
                if stack:
                    stack.pop()
                else:
                    res += 1

        return res + len(stack)


# Time Complexity: O(n)
# Space Complexity: O(n)


if __name__ == "__main__":
    solution = MinimumAddToMakeParenthesesValid()

    print("Expected Output : 1")
    print("Actual Output   :", solution.minAddToMakeValid("())"))

    print("Expected Output : 3")
    print("Actual Output   :", solution.minAddToMakeValid("((("))

    print("Expected Output : 4")
    print("Actual Output   :", solution.minAddToMakeValid("()())"))
