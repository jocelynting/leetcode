class RomanToInteger:
    def romanToInt(self, s: str) -> int:
        values = {"I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000}

        n = len(s)
        res = 0
        i = 0

        while i < n:
            if i + 1 < n and values[s[i]] < values[s[i + 1]]:
                res += values[s[i + 1]] - values[s[i]]
                i += 2
            else:
                res += values[s[i]]
                i += 1

        return res

    def romanToInt2(self, s: str) -> int:
        values = {
            "I": 1,
            "V": 5,
            "X": 10,
            "L": 50,
            "C": 100,
            "D": 500,
            "M": 1000,
            "IV": 4,
            "IX": 9,
            "XL": 40,
            "XC": 90,
            "CD": 400,
            "CM": 900,
        }

        n = len(s)
        res = 0
        i = 0

        while i < n:
            if i < n - 1 and s[i : i + 2] in values:
                res += values[s[i : i + 2]]
                i += 2
            else:
                res += values[s[i]]
                i += 1

        return res


# Time Complexity: O(1), since the maximum length of the input string is 15 (for "MMMCMXCIX")
# Space Complexity: O(1), since we are using a constant amount of space

if __name__ == "__main__":
    solution = RomanToInteger()

    print("Expected Output: 58")
    print("Actual Output:", solution.romanToInt("LVIII"))
    print("Actual Output:", solution.romanToInt2("LVIII"))

    print("Expected Output: 1994")
    print("Actual Output:", solution.romanToInt("MCMXCIV"))
    print("Actual Output:", solution.romanToInt2("MCMXCIV"))
