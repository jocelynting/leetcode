class IntegerToRoman:
    def intToRoman(self, num: int) -> str:
        roman_numerals = [
            (1000, "M"),
            (900, "CM"),
            (500, "D"),
            (400, "CD"),
            (100, "C"),
            (90, "XC"),
            (50, "L"),
            (40, "XL"),
            (10, "X"),
            (9, "IX"),
            (5, "V"),
            (4, "IV"),
            (1, "I"),
        ]

        res = ""
        for value, symbol in roman_numerals:
            while num >= value:
                res += symbol
                num -= value

        return res


if __name__ == "__main__":
    solution = IntegerToRoman()

    print("Expected Output : MMMDCCXLIX")
    print("Actual Output : ", solution.intToRoman(3749))

    print("Expected Output : LVIII")
    print("Actual Output : ", solution.intToRoman(58))

    print("Expected Output : MCMXCIV")
    print("Actual Output : ", solution.intToRoman(1994))
