class RepeatedSubstringPattern:
    def repeatedSubstringPattern(self, s: str) -> bool:
        return s in (s + s)[1:-1]


# Time Complexity: O(n), where n is the length of the string s
# Space Complexity: O(1), since we are not using any extra space that grows with input size

if __name__ == "__main__":
    solution = RepeatedSubstringPattern()

    print("Expected Output: True")
    print("Actual Output:", solution.repeatedSubstringPattern("abab"))

    print("Expected Output: False")
    print("Actual Output:", solution.repeatedSubstringPattern("aba"))
