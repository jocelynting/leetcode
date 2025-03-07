class ConcatenatedWords:
    def findAllConcatenatedWordsInADict(self, words: list[str]) -> list[str]:
        word_set = set(words)
        memo = {}

        def dfs(word: str, index: int, count: int) -> bool:
            n = len(word)

            if index == n:
                return count >= 1

            if index in memo:
                return memo[index]

            for i in range(index, n):
                prefix = word[index : i + 1]
                if prefix in word_set:
                    if dfs(word, i + 1, count + 1):
                        memo[index] = True
                        return True
            memo[index] = False
            return False

        res = []
        for word in words:
            word_set.remove(word)
            memo.clear()
            if dfs(word, 0, 0):
                res.append(word)
            word_set.add(word)

        return res


if __name__ == "__main__":
    solution = ConcatenatedWords()

    words1 = [
        "cat",
        "cats",
        "catsdogcats",
        "dog",
        "dogcatsdog",
        "hippopotamuses",
        "rat",
        "ratcatdogcat",
    ]
    print("Expected Output: ", ["catsdogcats", "dogcatsdog", "ratcatdogcat"])
    print("Actual Output: ", solution.findAllConcatenatedWordsInADict(words1))

    words2 = ["a", "aa", "aaa", "aaaa"]
    print("Expected Output: ", ["aa", "aaa", "aaaa"])
    print("Actual Output: ", solution.findAllConcatenatedWordsInADict(words2))
