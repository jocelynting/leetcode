from collections import Counter


class MinimumDeletionsForAtMostKDistinctCharacters:
    def minDeletion(self, s: str, k: int) -> int:
        count = Counter(s)

        if len(count) <= k:
            return 0

        freq = sorted(count.values())
        res = 0
        diff = len(count) - k

        for i in range(diff):
            res += freq[i]

        return res


# Time Complexity: O(n log n), where n is the length of the string s. This is due to the sorting of the frequency counts.
# Space Complexity: O(1), since s contains only lowercase letters, the space used for the frequency count is constant.

if __name__ == "__main__":
    solution = MinimumDeletionsForAtMostKDistinctCharacters()

    print("Expected Output: 1")
    print("Actual Output:", solution.minDeletion("aaabc", 2))

    print("Expected Output: 0")
    print("Actual Output:", solution.minDeletion("aab", 2))

    print("Expected Output: 1")
    print("Actual Output:", solution.minDeletion("abc", 2))
