class LongestPalindromicSubstring:
    def longestPalindrome(self, s: str) -> str:
        res = ''
        for i in range(len(s)):
            s1 = self.palindrome(s, i, i)
            s2 = self.palindrome(s, i, i + 1)

            res = res if len(res) > len(s1) else s1
            res = res if len(res) > len(s2) else s2
            # candidate = max(s1, s2, key=len)
            # res = max(res, candidate, key=len)

        return res

    def palindrome(self, s: str, left: int, right: int) -> str:
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1

        return s[left + 1: right]


if __name__ == '__main__':
    solution = LongestPalindromicSubstring()
    s1 = "babad"
    print("Expected Output: 'bab' or 'aba'")
    print("Actual Output:", solution.longestPalindrome(s1))

    s2 = "cbbd"
    print("Expected Output: 'bb'")
    print("Actual Output:", solution.longestPalindrome(s2))

    s3 = "a"
    print("Expected Output: 'a'")
    print("Actual Output:", solution.longestPalindrome(s3))
