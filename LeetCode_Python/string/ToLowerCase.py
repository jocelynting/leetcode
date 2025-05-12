class ToLowerCase:
    def toLowerCase(self, s: str) -> str:
        res = ""

        # ASCII values for uppercase letters A-Z are 65-90
        # ASCII values for lowercase letters a-z are 97-122

        for char in s:
            if 65 <= ord(char) <= 90:
                res += chr(ord(char) - 65 + 97)
            else:
                res += char

        return res


# Time Complexity: O(n), where n is the length of the string
# Space Complexity: O(n), since we are using a string to store the result

if __name__ == "__main__":
    solution = ToLowerCase()

    print("Expected Output: hello")
    print("Actual Output:", solution.toLowerCase("Hello"))

    print("Expected Output: aaaaaa")
    print("Actual Output:", solution.toLowerCase("Aaaaaa"))

    print("Expected Output: aaaaaaa")
    print("Actual Output:", solution.toLowerCase("AAAAAAA"))
