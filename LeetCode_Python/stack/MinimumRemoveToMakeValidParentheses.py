class MinimumRemoveToMakeValidParentheses:
    def minRemoveToMakeValid(self, s: str) -> str:
        arr = list(s)
        stack = []

        for i, char in enumerate(arr):
            if char == "(":
                stack.append(i)
            elif char == ")":
                if stack:
                    stack.pop()
                else:
                    arr[i] = ""

        while stack:
            arr[stack.pop()] = ""

        return "".join(arr)


# Time Complexity: O(n)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = MinimumRemoveToMakeValidParentheses()

    s = "lee(t(c)o)de)"
    print("Expected Output : lee(t(c)o)de")
    print("Actual Output :", solution.minRemoveToMakeValid(s))

    s = "a)b(c)d"
    print("Expected Output : ab(c)d")
    print("Actual Output :", solution.minRemoveToMakeValid(s))

    s = "))(("
    print("Expected Output : ")
    print("Actual Output :", solution.minRemoveToMakeValid(s))

    s = "(a(b(c)d)"
    print("Expected Output : a(b(c)d)")
    print("Actual Output :", solution.minRemoveToMakeValid(s))
