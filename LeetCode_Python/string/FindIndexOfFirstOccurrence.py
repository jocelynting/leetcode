class FindIndexOfFirstOccurrence:
    def strStr(self, haystack: str, needle: str) -> int:
        m, n = len(haystack), len(needle)

        for i in range(m - n + 1):
            cur = haystack[i : i + n]
            if cur == needle:
                return i

        return -1


# Time Complexity: O(m * n), where m is the length of haystack and n is the length of needle
# Space Complexity: O(1), since we are not using any extra space that grows with input size


if __name__ == "__main__":
    solution = FindIndexOfFirstOccurrence()

    print("Expected Output: 2")
    print("Actual Output:", solution.strStr("hello", "ll"))

    print("Expected Output: -1")
    print("Actual Output:", solution.strStr("aaaaa", "bba"))
