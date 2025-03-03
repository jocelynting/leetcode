from collections import Counter


class FindAllAnagrams:
    def findAnagrams(self, s: str, p: str) -> list[int]:
        sl, pl = len(s), len(p)
        if sl < pl:
            return []

        p_count = Counter(p)
        s_count = Counter()

        res = []

        for i in range(sl):
            s_count[s[i]] += 1
            if i >= pl:
                if s_count[s[i - pl]] == 1:
                    del s_count[s[i - pl]]
                else:
                    s_count[s[i - pl]] -= 1

            if p_count == s_count:
                res.append(i - pl + 1)

        return res


if __name__ == "__main__":
    solution = FindAllAnagrams()
    s1 = "cbaebabacd"
    p1 = "abc"
    print("Expected Output: [0, 6]")
    print("Actual Output:", solution.findAnagrams(s1, p1))

    s2 = "abab"
    p2 = "ab"
    print("Expected Output: [0, 1, 2]")
    print("Actual Output:", solution.findAnagrams(s2, p2))

    s3 = "a"
    p3 = "ab"
    print("Expected Output: []")
    print("Actual Output:", solution.findAnagrams(s3, p3))
