class LongestSubstringWithAtMostKDistinctCharacters:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        left = 0
        count = {}
        max_len = 0

        for right, char in enumerate(s):
            count[char] = count.get(char, 0) + 1

            while len(count) > k:
                count[s[left]] -= 1
                if count[s[left]] == 0:
                    del count[s[left]]
                left += 1

            max_len = max(max_len, right - left + 1)

        return max_len


if __name__ == "__main__":
    solution = LongestSubstringWithAtMostKDistinctCharacters()

    print("Expected Output : 3")
    print("Actual Output :", solution.lengthOfLongestSubstringKDistinct("eceba", 2))

    print("Expected Output : 2")
    print("Actual Output :", solution.lengthOfLongestSubstringKDistinct("aa", 1))
