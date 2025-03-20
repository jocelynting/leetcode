class GenerateParentheses:
    def generateParenthesis(self, n: int) -> list[str]:
        res = []

        def backtracking(left: int, right: int, path: str):
            if left == 0 and right == 0:
                res.append(path)
                return

            if left < n:
                backtracking(left + 1, right, path + "(")

            if right < left:
                backtracking(left, right + 1, path + ")")

        backtracking(0, 0, "")
        return res


# Time Complexity: O(4^n / sqrt(n))
# Space Complexity: O(n)


if __name__ == "__main__":
    solution = GenerateParentheses()

    print("Expected Output: ['((()))', '(()())', '(())()', '()(())', '()()()']")
    print("Actual Output:", solution.generateParenthesis(3))

    print("Expected Output: ['()']")
    print("Actual Output:", solution.generateParenthesis(1))
