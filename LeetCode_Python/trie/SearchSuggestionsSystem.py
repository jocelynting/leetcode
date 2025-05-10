class TrieNode:
    def __init__(self):
        self.children = {}
        self.suggestions = []


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str):
        node = self.root
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]
            if len(node.suggestions) < 3:
                node.suggestions.append(word)

    def suggestions(self, prefix: str) -> list[list[str]]:
        node = self.root
        res = []
        for char in prefix:
            if char not in node.children:
                return []
            node = node.children[char]
            res.append(node.suggestions)

        return res


class SearchSuggestionsSystem:
    def suggestedProducts(
        self, products: list[str], searchWord: str
    ) -> list[list[str]]:
        products.sort()
        trie = Trie()

        for product in products:
            trie.insert(product)

        return trie.suggestions(searchWord)


# Time Complexity: O(mlog m + m * L)
# sorting the products takes O(mlog m), where m is the number of products.
# inserting each product into the trie takes O(m * L), where L is the average length of the products.
# searching for suggestions takes O(n), where n is the length of the searchWord.
# Space Complexity: O(m * L)
# where m is the number of products and L is the average length of the products.


if __name__ == "__main__":
    solution = SearchSuggestionsSystem()

    products = ["mobile", "mouse", "moneypot", "monitor", "mousepad"]
    searchWord = "mouse"
    print(
        "Expected Output: [['mobile', 'moneypot', 'monitor'], ['mobile', 'moneypot', 'monitor'], ['mouse', 'mousepad'], ['mouse', 'mousepad'], ['mouse', 'mousepad']]"
    )
    print("Actual Output:", solution.suggestedProducts(products, searchWord))

    products = ["havana"]
    searchWord = "havana"
    print(
        "Expected Output: [['havana'], ['havana'], ['havana'], ['havana'], ['havana'], ['havana']]"
    )
    print("Actual Output:", solution.suggestedProducts(products, searchWord))
