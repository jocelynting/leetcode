from collections import Counter


class MinimumWindowSubstring:
    def minWindow(self, s: str, t: str) -> str:
        if len(s) < len(t):
            return ""

        left, right = 0, 0
        start, min_len = 0, float("inf")
        count = Counter(t)
        required = len(t)

        while right < len(s):
            if s[right] in count:
                count[s[right]] -= 1
                if count[s[right]] >= 0:
                    required -= 1

            while required == 0:
                if right - left + 1 < min_len:
                    min_len = right - left + 1
                    start = left

                if s[left] in count:
                    count[s[left]] += 1
                    if count[s[left]] > 0:
                        required += 1
                left += 1

            right += 1

        return "" if min_len == float("inf") else s[start : start + min_len]


if __name__ == "__main__":
    solution = MinimumWindowSubstring()

    s = "ADOBECODEBANC"
    t = "ABC"
    print("Expected Output : BANC")
    print("Actual Output : ", solution.minWindow(s, t))

    s = "a"
    t = "a"
    print("Expected Output : a")
    print("Actual Output : ", solution.minWindow(s, t))

    s = "a"
    t = "aa"
    print("Expected Output : ")
    print("Actual Output : ", solution.minWindow(s, t))
