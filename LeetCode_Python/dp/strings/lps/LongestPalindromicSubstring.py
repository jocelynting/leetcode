class LongestPalindromicSubstring:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        if n < 2:
            return s

        dp = [[False] * n for _ in range(n)]
        start, max_length = 0, 1

        for i in range(n):
            dp[i][i] = True

        for i in range(n - 1):
            if s[i] == s[i + 1]:
                dp[i][i + 1] = True
                start = i
                max_length = 2

        for length in range(3, n + 1):
            for i in range(n - length + 1):
                j = i + length - 1
                if s[i] == s[j] and dp[i + 1][j - 1]:
                    dp[i][j] = True
                    if length > max_length:
                        start = i
                        max_length = length

        return s[start: start + max_length]


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
