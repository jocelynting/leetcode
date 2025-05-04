from collections import Counter


class NumberOfEquivalentDominoPairs:
    def numEquivDominoPairs(self, dominoes: list[list[int]]) -> int:
        count = Counter()
        res = 0

        for a, b in dominoes:
            key = (min(a, b), max(a, b))
            res += count[key]
            count[key] += 1

        return res


# Time Complexity: O(n), where n is the number of dominoes
# Space Complexity: O(n), where n is the number of unique dominoes

if __name__ == "__main__":
    solution = NumberOfEquivalentDominoPairs()

    print("Expected Output: 1")
    print(
        "Actual Output:", solution.numEquivDominoPairs([[1, 2], [2, 1], [3, 4], [5, 6]])
    )

    print("Expected Output: 0")
    print("Actual Output:", solution.numEquivDominoPairs([[1, 2], [3, 4], [5, 6]]))

    print("Expected Output: 3")
    print(
        "Actual Output:",
        solution.numEquivDominoPairs([[1, 2], [2, 1], [3, 4], [4, 3], [5, 6], [6, 5]]),
    )
