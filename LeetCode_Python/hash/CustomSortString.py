from collections import Counter


class CustomSortString:
    def customSortString(self, order: str, s: str) -> str:
        counter = Counter(s)
        res = []

        for char in order:
            if char in counter:
                res.append(char * counter[char])
                del counter[char]

        for char, freq in counter.items():
            res.append(char * freq)

        return "".join(res)


# Time Complexity: O(n + m), where n is the length of s and m is the length of order.
# Space Complexity: O(n), where n is the length of s.

if __name__ == "__main__":
    solution = CustomSortString()

    print("Expected Output: cbadef")
    print("Actual Output:", solution.customSortString("cba", "abcdfe"))

    print("Expected Output: kqpee")
    print("Actual Output:", solution.customSortString("kq", "pqeek"))

    print("Expected Output: aaabbbcc")
    print("Actual Output:", solution.customSortString("abc", "aaabbbcc"))
