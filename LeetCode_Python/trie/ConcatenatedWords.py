class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end = False


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]
        node.is_end = True

    def search(self, word: str, index: int, count: int) -> bool:
        node = self.root
        n = len(word)

        for i in range(index, n):
            char = word[i]
            if char not in node.children:
                return False
            node = node.children[char]
            if node.is_end:
                if i == n - 1:
                    return count >= 1
                if self.search(word, i + 1, count + 1):
                    return True
        return False


class ConcatenatedWords:
    def findAllConcatenatedWordsInADict(self, words: list[str]) -> list[str]:
        words.sort(key=len)
        trie = Trie()
        res = []

        for word in words:
            if not word:
                continue
            if trie.search(word, 0, 0):
                res.append(word)
            else:
                trie.insert(word)

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
