class NumberOfSubstringsContainingAllThreeCharacters:
    def numberOfSubstrings(self, s: str) -> int:
        n = len(s)
        left = right = 0
        count = {"a": 0, "b": 0, "c": 0}
        res = 0

        while right < n:
            count[s[right]] += 1

            while count["a"] > 0 and count["b"] > 0 and count["c"] > 0:
                res += n - right
                l = s[left]
                count[s[left]] -= 1
                left += 1

            right += 1

        return res


if __name__ == "__main__":
    solution = NumberOfSubstringsContainingAllThreeCharacters()

    print("Expected Output : 10")
    print("Actual Output : ", solution.numberOfSubstrings("abcabc"))

    print("Expected Output : 3")
    print("Actual Output : ", solution.numberOfSubstrings("aaacb"))

    print("Expected Output : 1")
    print("Actual Output : ", solution.numberOfSubstrings("abc"))
