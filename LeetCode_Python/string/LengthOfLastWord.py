class LengthOfLastWord:
    def lengthOfLastWord(self, s: str) -> int:
        count = 0

        for i in range(len(s) - 1, -1, -1):
            if s[i] == " ":
                if count > 0:
                    break
            else:
                count += 1

        return count

    # Time Complexity: O(n), where n is the length of the string
    # Space Complexity: O(1), since we are using a constant amount of space

    def lengthOfLastWord2(self, s: str) -> int:
        s = s.strip()
        words = s.split(" ")
        return len(words[-1])

    # Time Complexity: O(n), where n is the length of the string
    # Space Complexity: O(n), since we are using a list to store the words


if __name__ == "__main__":
    solution = LengthOfLastWord()

    print("Expected Output: 5")
    print("Actual Output:", solution.lengthOfLastWord("Hello World"))
    print("Actual Output:", solution.lengthOfLastWord2("Hello World"))

    print("Expected Output: 4")
    print("Actual Output:", solution.lengthOfLastWord("   fly me   to   the moon  "))
    print("Actual Output:", solution.lengthOfLastWord2("   fly me   to   the moon  "))

    print("Expected Output: 1")
    print("Actual Output:", solution.lengthOfLastWord("a"))
    print("Actual Output:", solution.lengthOfLastWord2("a"))
