from collections import Counter


class TopKFrequentWords:
    def topKFrequent(self, words: list[str], k: int) -> list[str]:
        count = Counter(words)
        sorted_count = sorted(count, key=lambda x: (-count[x], x))
        return sorted_count[:k]


if __name__ == "__main__":
    solution = TopKFrequentWords()

    print("Expected Output: ['i', 'love']")
    print(
        "Actual Output:",
        solution.topKFrequent(["i", "love", "leetcode", "i", "love", "coding"], 2),
    )

    print("Expected Output: ['the', 'is', 'sunny', 'day']")
    print(
        "Actual Output:",
        solution.topKFrequent(
            ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], 4
        ),
    )
