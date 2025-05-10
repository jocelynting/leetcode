from collections import Counter


class FindTheDifference:
    def findTheDifference(self, s: str, t: str) -> str:
        count = Counter(s)

        for char in t:
            if count[char] == 0:
                return char
            count[char] -= 1

        return ""


# Time Complexity: O(n), where n is the length of the string t
# Space Complexity: O(1), since the size of the counter is constant (26 letters)

if __name__ == "__main__":
    solution = FindTheDifference()

    print("Expected Output: e")
    print("Actual Output:", solution.findTheDifference("abcd", "abcde"))

    print("Expected Output: a")
    print("Actual Output:", solution.findTheDifference("a", "aa"))
