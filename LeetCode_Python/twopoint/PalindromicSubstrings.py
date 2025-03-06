class PalindromicSubstrings:
    def countSubstrings(self, s: str) -> int:
        n = len(s)

        def count(left: int, right: int) -> int:
            count = 0

            while left >= 0 and right < n:
                if s[left] != s[right]:
                    break
                count += 1
                left -= 1
                right += 1

            return count

        res = 0

        for i in range(n):
            res += count(i, i)
            res += count(i, i + 1)

        return res


if __name__ == "__main__":
    solution = PalindromicSubstrings()

    print("Expected Output : 3")
    print("Actual Output : ", solution.countSubstrings("abc"))

    print("Expected Output : 6")
    print("Actual Output : ", solution.countSubstrings("aaa"))

    print("Expected Output : 6")
    print("Actual Output : ", solution.countSubstrings("abba"))
