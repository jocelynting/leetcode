from collections import Counter
import re


class MostCommonWord:
    def mostCommonWord(self, paragraph: str, banned: list[str]) -> str:
        words = re.findall(r'\w+', paragraph.lower())
        banned_set = set(banned)
        counter = Counter(word for word in words if word not in banned_set)
        return counter.most_common(1)[0][0]


if __name__ == '__main__':
    solution = MostCommonWord()
    paragraph1 = "Bob hit a ball, the hit BALL flew far after it was hit."
    banned1 = ["hit"]
    print("Expected Output: ball")
    print("Actual Output:", solution.mostCommonWord(paragraph1, banned1))

    paragraph2 = "a, a, a, a, b,b,b,c, c"
    banned2 = ["a"]
    print("Expected Output: b")
    print("Actual Output:", solution.mostCommonWord(paragraph2, banned2))
