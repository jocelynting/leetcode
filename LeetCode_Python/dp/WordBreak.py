class WordBreak:
    def wordBreak(self, s: str, wordDict: list[str]) -> bool:
        n = len(s)
        dp = [False] * (n + 1)
        dp[0] = True

        for i in range(1, n + 1):
            for word in wordDict:
                length = len(word)
                if i >= length and s[i - length : i] == word and dp[i - length]:
                    dp[i] = True
                    break

        return dp[n]


# Time Complexity: O(n^2)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = WordBreak()

    print("Excepted Output: True")
    print("Actual Output: ", solution.wordBreak("leetcode", ["leet", "code"]))

    print("Excepted Output: True")
    print("Actual Output: ", solution.wordBreak("applepenapple", ["apple", "pen"]))

    print("Excepted Output: False")
    print(
        "Actual Output: ",
        solution.wordBreak("catsandog", ["cats", "dog", "sand", "and", "cat"]),
    )
