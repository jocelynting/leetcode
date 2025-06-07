class ValidWordAbbreviation:
    def isValid(self, word: str, abbr: str) -> bool:
        n1, n2 = len(word), len(abbr)
        i = j = 0

        while i < n1 and j < n2:
            c1 = word[i]
            c2 = abbr[j]
            if c2.isdigit():
                if c2 == "0":
                    return False
                num = 0
                while j < n2 and abbr[j].isdigit():
                    num = num * 10 + int(abbr[j])
                    j += 1
                i += num
            else:
                if c1 == c2:
                    i += 1
                    j += 1
                else:
                    return False

        return i == n1 and j == n2


# Time Complexity: O(n1 + n2), where n1 is the length of the word and n2 is the length of the abbreviation.
# Space Complexity: O(1), as we are using a constant amount of space for variables.

if __name__ == "__main__":
    solution = ValidWordAbbreviation()

    print("Expected Output: True")
    print("Actual Output:", solution.isValid("internationalization", "i12iz4n"))

    print("Expected Output: False")
    print("Actual Output:", solution.isValid("apple", "a2e"))

    print("Expected Output: False")
    print("Actual Output:", solution.isValid("word", "w1r1d"))

    print("Expected Output: False")
    print("Actual Output:", solution.isValid("word", "w0rd"))
