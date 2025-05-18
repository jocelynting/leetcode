class StringToInteger:
    def myAtoi(self, s: str) -> int:
        n = len(s)
        i = 0
        res = 0
        sign = 1

        while i < n and s[i] == " ":
            i += 1

        if i < n and (s[i] == "+" or s[i] == "-"):
            sign = 1 if s[i] == "+" else -1
            i += 1

        while i < n and s[i].isdigit():
            res = res * 10 + int(s[i])
            i += 1

        res *= sign

        INT_MAX = 2**31 - 1
        INT_MIN = -(2**31)

        if res < INT_MIN:
            return INT_MIN
        if res > INT_MAX:
            return INT_MAX

        return res


# Time Complexity: O(n), where n is the length of the string s.
# Space Complexity: O(1), no extra space is used.

if __name__ == "__main__":
    solution = StringToInteger()

    print("Expected Output: 42")
    print("Actual Output:", solution.myAtoi("42"))

    print("Expected Output: -42")
    print("Actual Output:", solution.myAtoi("   -42"))

    print("Expected Output: 4193")
    print("Actual Output:", solution.myAtoi("4193 with words"))

    print("Expected Output: 0")
    print("Actual Output:", solution.myAtoi("words and 987"))

    print("Expected Output: 0")
    print("Actual Output:", solution.myAtoi("+-2"))

    print("Expected Output: -2147483647")
    print("Actual Output:", solution.myAtoi("-91283472332"))
