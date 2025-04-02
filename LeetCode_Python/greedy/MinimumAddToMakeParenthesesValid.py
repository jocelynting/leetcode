class MinimumAddToMakeParenthesesValid:
    def minAddToMakeValid(self, s: str) -> int:
        left = right = 0

        for char in s:
            if char == "(":
                left += 1
            else:
                if left > 0:
                    left -= 1
                else:
                    right += 1

        return left + right


# Time Complexity: O(n)
# Space Complexity: O(1)


if __name__ == "__main__":
    solution = MinimumAddToMakeParenthesesValid()

    print("Expected Output : 1")
    print("Actual Output   :", solution.minAddToMakeValid("())"))

    print("Expected Output : 3")
    print("Actual Output   :", solution.minAddToMakeValid("((("))

    print("Expected Output : 4")
    print("Actual Output   :", solution.minAddToMakeValid("()())"))
