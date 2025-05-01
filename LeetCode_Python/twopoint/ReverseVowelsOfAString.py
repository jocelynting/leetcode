class ReverseVowelsOfAString:
    def reverseVowels(self, s: str) -> str:
        """
        :type s: str
        :rtype: str
        """
        vowels = set("aeiouAEIOU")
        s = list(s)
        i, j = 0, len(s) - 1
        while i < j:
            if s[i] not in vowels:
                i += 1
            elif s[j] not in vowels:
                j -= 1
            else:
                s[i], s[j] = s[j], s[i]
                i += 1
                j -= 1
        return "".join(s)


# Time Complexity: O(n), where n is the length of the string
# Space Complexity: O(n), we are using a list to store the characters of the string

if __name__ == "__main__":
    solution = ReverseVowelsOfAString()

    print("Expected Output : holle")
    print("Actual Output : ", solution.reverseVowels("hello"))

    print("Expected Output : leotcede")
    print("Actual Output : ", solution.reverseVowels("leetcode"))
