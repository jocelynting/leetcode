from collections import Counter


class DetermineIfTwoStringsAreClose:
    def closeStrings(self, word1: str, word2: str) -> bool:
        if len(word1) != len(word2):
            return False

        count1 = Counter(word1)
        count2 = Counter(word2)

        if set(count1.keys()) != set(count2.keys()):
            return False

        return sorted(count1.values()) == sorted(count2.values())

    # Time Complexity: O(m + n + klog(k)), where m and n are the lengths of word1 and word2, and k is the number of unique characters in the strings.
    # Space Complexity: O(1), since the number of unique characters is limited to 26 lowercase letters.

    def closeStringsByOrd(self, word1: str, word2: str) -> bool:
        if len(word1) != len(word2):
            return False

        count1 = [0] * 26
        count2 = [0] * 26

        for char in word1:
            count1[ord(char) - ord("a")] += 1
        for char in word2:
            count2[ord(char) - ord("a")] += 1

        for i in range(26):
            if count1[i] == 0 and count2[i] != 0:
                return False
            if count1[i] != 0 and count2[i] == 0:
                return False

        return sorted(count1) == sorted(count2)

    # Time Complexity: O(m + n + klog(k)), where m and n are the lengths of word1 and word2, and k is the number of unique characters in the strings.
    # Space Complexity: O(1), since the number of unique characters is limited to 26 lowercase letters.


if __name__ == "__main__":
    solution = DetermineIfTwoStringsAreClose()

    print("Expected Output: True")
    print("Actual Output:", solution.closeStrings("abc", "bca"))

    print("Expected Output: False")
    print("Actual Output:", solution.closeStrings("a", "aa"))

    print("Expected Output: False")
    print("Actual Output:", solution.closeStrings("cabbba", "abbccc"))
