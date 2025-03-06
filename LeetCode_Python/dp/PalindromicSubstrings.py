class PalindromicSubstrings:
    def countSubstrings(self, s: str) -> int:
        n = len(s)

        dp = [[False] * n for _ in range(n)]
        res = 0

        for i in range(n):
            dp[i][i] = True
            res += 1

        for i in range(n - 1):
            if s[i] == s[i + 1]:
                dp[i][i + 1] = True
                res += 1

        for length in range(3, n + 1):
            for i in range(n - length + 1):
                j = i + length - 1
                if s[i] == s[j] and dp[i + 1][j - 1]:
                    dp[i][j] = True
                    res += 1

        return res


if __name__ == "__main__":
    solution = PalindromicSubstrings()

    print("Expected Output : 3")
    print("Actual Output : ", solution.countSubstrings("abc"))

    print("Expected Output : 6")
    print("Actual Output : ", solution.countSubstrings("aaa"))

    print("Expected Output : 6")
    print("Actual Output : ", solution.countSubstrings("abba"))
