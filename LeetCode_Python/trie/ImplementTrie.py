class TrieNode:
    def __init__(self):
        self.children = {}
        self.end_of_word = False


class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root
        for ch in word:
            if ch not in node.children:
                node.children[ch] = TrieNode()
            node = node.children[ch]
        node.end_of_word = True

    def search(self, word: str) -> bool:
        node = self.find(word)
        return node is not None and node.end_of_word

    def startsWith(self, prefix: str) -> bool:
        node = self.find(prefix)
        return node is not None

    def find(self, word: str) -> TrieNode:
        node = self.root
        for ch in word:
            if ch not in node.children:
                return None
            node = node.children[ch]
        return node


if __name__ == "__main__":
    solution = Trie()

    solution.insert("apple")
    print("Expected Output : True")
    print("Actual Output : ", solution.search("apple"))
    print("Expected Output : False")
    print("Actual Output : ", solution.search("app"))
    print("Expected Output : True")
    print("Actual Output : ", solution.startsWith("app"))
    solution.insert("app")
    print("Expected Output : True")
    print("Actual Output : ", solution.search("app"))
