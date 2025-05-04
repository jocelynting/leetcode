class RemovingStarsFromString:
    def removeStars(self, s: str) -> str:
        stack = []

        for char in s:
            if char == "*":
                if stack:
                    stack.pop()
            else:
                stack.append(char)

        return "".join(stack)


# Time Complexity: O(n), where n is the length of the input string
# Space Complexity: O(n), where n is the length of the input string

if __name__ == "__main__":
    solution = RemovingStarsFromString()

    print("Expected Output: lecoe")
    print("Actual Output:", solution.removeStars("leet**cod*e"))

    print("Expected Output: ")
    print("Actual Output:", solution.removeStars("erase*****"))
