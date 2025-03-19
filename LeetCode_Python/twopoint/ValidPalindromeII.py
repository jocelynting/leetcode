class ValidPalindromeII:
    def validPalindrome(self, s: str) -> bool:
        n = len(s)
        if n == 1:
            return True

        left, right = 0, n - 1

        while left < right:
            if s[left] == s[right]:
                left += 1
                right -= 1
            else:
                return self.isPalindrome(s, left + 1, right) or self.isPalindrome(
                    s, left, right - 1
                )
        return True

    def isPalindrome(self, s: str, left: int, right: int) -> bool:
        while left < right:
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1
        return True


if __name__ == "__main__":
    solution = ValidPalindromeII()

    print("Expected Output: True")
    print("Actual Output:", solution.validPalindrome("aba"))

    print("Expected Output: True")
    print("Actual Output:", solution.validPalindrome("abca"))

    print("Expected Output: False")
    print("Actual Output:", solution.validPalindrome("abc"))
