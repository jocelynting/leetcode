class ReverseWordsInAStringII:
    def reverseWords(self, s: list[str]) -> None:
        def reverse(left: int, right: int) -> None:
            while left < right:
                s[left], s[right] = s[right], s[left]
                left += 1
                right -= 1

        n = len(s)
        reverse(0, n - 1)

        start = 0
        for end in range(n + 1):
            if end == n or s[end] == " ":
                reverse(start, end - 1)
                start = end + 1


# Time Complexity: O(n), where n is the length of the string
# Space Complexity: O(1), we are using a list to store the characters of the string

if __name__ == "__main__":
    solution = ReverseWordsInAStringII()

    s = ["t", "h", "e", " ", "s", "k", "y", " ", "i", "s", " ", "b", "l", "u", "e"]
    solution.reverseWords(s)
    print(
        "Expected Output : ['b', 'l', 'u', 'e', ' ', 'i', 's', ' ', 's', 'k', 'y', ' ', 't', 'h', 'e']"
    )
    print("Actual Output : ", s)

    s = ["h", "e", "l", "l", "o"]
    solution.reverseWords(s)
    print("Expected Output : ['h', 'e', 'l', 'l', 'o']")
    print("Actual Output : ", s)

    s = ["a"]
    solution.reverseWords(s)
    print("Expected Output : ['a']")
    print("Actual Output : ", s)
