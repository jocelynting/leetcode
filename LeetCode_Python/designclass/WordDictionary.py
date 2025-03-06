class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end = False


class WordDictionary:

    def __init__(self):
        self.root = TrieNode()

    def addWord(self, word: str) -> None:
        node = self.root
        for ch in word:
            if ch not in node.children:
                node.children[ch] = TrieNode()
            node = node.children[ch]
        node.is_end = True

    def search(self, word: str) -> bool:
        def dfs(node: TrieNode, index: int) -> bool:
            if index == len(word):
                return node.is_end
            char = word[index]
            if char == ".":
                for n in node.children.values():
                    if dfs(n, index + 1):
                        return True
                return False
            else:
                if char not in node.children:
                    return False
                return dfs(node.children[char], index + 1)

        return dfs(self.root, 0)


if __name__ == "__main__":
    solution = WordDictionary()

    solution.addWord("bad")
    solution.addWord("dad")
    solution.addWord("mad")
    print("Expected Output : False")
    print("Actual Output : ", solution.search("pad"))
    print("Expected Output : True")
    print("Actual Output : ", solution.search("bad"))
    print("Expected Output : True")
    print("Actual Output : ", solution.search(".ad"))
    print("Expected Output : True")
    print("Actual Output : ", solution.search("b.."))
    print("Expected Output : False")
    print("Actual Output : ", solution.search("b..."))
    print("Expected Output : False")
    print("Actual Output : ", solution.search("b"))
    print("Expected Output : False")
    print("Actual Output : ", solution.search("ba"))
