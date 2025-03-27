class PalindromeNumber:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False

        cur = x
        rev = 0
        while cur:
            rev = rev * 10 + cur % 10
            cur //= 10

        return rev == x


# Time Complexity: O(log10(n))
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = PalindromeNumber()

    x1 = 121
    print("Expected Output: True")
    print("Actual Output:", solution.isPalindrome(x1))

    x2 = -121
    print("Expected Output: False")
    print("Actual Output:", solution.isPalindrome(x2))

    x3 = 10
    print("Expected Output: False")
    print("Actual Output:", solution.isPalindrome(x3))
