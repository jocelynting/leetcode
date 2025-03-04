from collections import Counter


class LongestSubstringWithoutRepeatingCharacters:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        if n < 2:
            return n

        char_set = set()
        left = 0
        max_length = 0

        for right in range(n):
            while s[right] in char_set:
                char_set.remove(s[left])
                left += 1

            char_set.add(s[right])
            max_length = max(max_length, right - left + 1)

        return max_length

    def lengthOfLongestSubstringByCounter(self, s: str) -> int:
        n = len(s)
        if n < 2:
            return n

        count = Counter()
        left, right = 0, 0
        max_length = 0

        while right < n:
            r = s[right]
            count[r] += 1

            while count[r] > 1:
                l = s[left]
                count[l] -= 1
                left += 1

            max_length = max(max_length, right - left + 1)
            right += 1

        return max_length


if __name__ == '__main__':
    solution = LongestSubstringWithoutRepeatingCharacters()
    s1 = "abcabcbb"
    print("Expected Output:", 3)
    print("Actual Output:", solution.lengthOfLongestSubstring(s1))
    print("Actual Output:", solution.lengthOfLongestSubstringByCounter(s1))

    s2 = "bbbbb"
    print("Expected Output:", 1)
    print("Actual Output:", solution.lengthOfLongestSubstring(s2))
    print("Actual Output:", solution.lengthOfLongestSubstringByCounter(s2))

    s3 = "pwwkew"
    print("Expected Output:", 3)
    print("Actual Output:", solution.lengthOfLongestSubstring(s3))
    print("Actual Output:", solution.lengthOfLongestSubstringByCounter(s3))
