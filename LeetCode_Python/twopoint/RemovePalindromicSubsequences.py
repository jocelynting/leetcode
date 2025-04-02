class RemovePalindromicSubsequences:
    def removePalindromeSub(self, s: str) -> int:
        def isPalindrome(s: str) -> bool:
            left, right = 0, len(s) - 1

            while left < right:
                if s[left] != s[right]:
                    return False
                left += 1
                right -= 1
            return True

        if not s:
            return 0
        if isPalindrome(s):
            return 1
        return 2


# Time Complexity: O(n)
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = RemovePalindromicSubsequences()
    s = "ababa"
    print("Expected Output: 1")
    print("Actual Output:", solution.removePalindromeSub(s))

    s = "abb"
    print("Expected Output: 2")
    print("Actual Output:", solution.removePalindromeSub(s))

    s = ""
    print("Expected Output: 0")
    print("Actual Output:", solution.removePalindromeSub(s))
