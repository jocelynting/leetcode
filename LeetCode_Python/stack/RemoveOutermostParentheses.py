class RemoveOutermostParentheses:
    def removeOuterParentheses(self, s: str) -> str:
        stack = []
        result = []

        for char in s:
            if char == "(":
                if stack:
                    result.append(char)
                stack.append(char)
            else:
                stack.pop()
                if stack:
                    result.append(char)

        return "".join(result)


# Time Complexity: O(n)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = RemoveOutermostParentheses()

    print('Expected Output: "()()()"')
    print("Actual Output:", solution.removeOuterParentheses("(()())(())"))

    print('Expected Output: "()()()()(())"')
    print("Actual Output:", solution.removeOuterParentheses("(()())(())(()(()))"))
