class LongestValidParentheses:
    def longestValidParentheses(self, s: str) -> int:
        stack = [-1]
        max_length = 0

        for i in range(len(s)):
            char = s[i]
            if char == "(":
                stack.append(i)
            else:
                stack.pop()
                if not stack:
                    stack.append(i)
                else:
                    max_length = max(max_length, i - stack[-1])

        return max_length


# Time Complexity: O(n)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = LongestValidParentheses()

    print("Expected Output: 2")
    print("Actual Output:", solution.longestValidParentheses("(()"))

    print("Expected Output: 4")
    print("Actual Output:", solution.longestValidParentheses(")()())"))
