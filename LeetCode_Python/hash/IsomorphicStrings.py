class IsomorphicStrings:
    def isIsomorphic(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        s2t = {}
        t2s = {}

        for i in range(len(s)):
            if s[i] in s2t and s2t[s[i]] != t[i]:
                return False

            if t[i] in t2s and t2s[t[i]] != s[i]:
                return False

            s2t[s[i]] = t[i]
            t2s[t[i]] = s[i]

        return True


# Time Complexity: O(n)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = IsomorphicStrings()

    print("Expected Output: True")
    print("Actual Output:", solution.isIsomorphic("egg", "add"))

    print("Expected Output: False")
    print("Actual Output:", solution.isIsomorphic("foo", "bar"))

    print("Expected Output: True")
    print("Actual Output:", solution.isIsomorphic("paper", "title"))
