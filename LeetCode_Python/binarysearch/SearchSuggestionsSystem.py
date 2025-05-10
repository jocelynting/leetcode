import bisect


class SearchSuggestionsSystem:
    def suggestedProducts(
        self, products: list[str], searchWord: str
    ) -> list[list[str]]:
        products.sort()
        res = []
        prefix = ""

        for char in searchWord:
            prefix += char
            index = bisect.bisect_left(products, prefix)
            suggestions = []
            for i in range(index, min(index + 3, len(products))):
                if products[i].startswith(prefix):
                    suggestions.append(products[i])
            res.append(suggestions)

        return res


# Time Complexity: O(mlog m + nlog m)
# sorting the products takes O(mlog m), where m is the number of products.
# searching for index and three suggestions takes O(nlog m + 3n), n is the length of prefix.
# Space Complexity: O(n), where n is the number of products.

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
