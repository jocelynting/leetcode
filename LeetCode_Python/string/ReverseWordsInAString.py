class ReverseWordsInAString:
    def reverseWords(self, s: str) -> str:
        words = s.split()
        words.reverse()
        return " ".join(words)


# Time Complexity: O(n), where n is the length of the string
# Space Complexity: O(n), we are using a list to store the words of the string

if __name__ == "__main__":
    solution = ReverseWordsInAString()

    print("Expected Output : blue is sky the")
    print("Actual Output : ", solution.reverseWords("the sky is blue"))

    print("Expected Output : world hello")
    print("Actual Output : ", solution.reverseWords("  hello world  "))

    print("Expected Output : example good a")
    print("Actual Output : ", solution.reverseWords("a good   example"))
