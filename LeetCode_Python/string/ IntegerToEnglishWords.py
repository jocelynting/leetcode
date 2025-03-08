class IntegerToEnglishWords:
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"

        lessThan20 = [
            "",
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten",
            "Eleven",
            "Twelve",
            "Thirteen",
            "Fourteen",
            "Fifteen",
            "Sixteen",
            "Seventeen",
            "Eighteen",
            "Nineteen",
        ]
        tens = [
            "",
            "",
            "Twenty",
            "Thirty",
            "Forty",
            "Fifty",
            "Sixty",
            "Seventy",
            "Eighty",
            "Ninety",
        ]
        thousands = ["", "Thousand", "Million", "Billion"]

        def helper(n: int) -> str:
            if n == 0:
                return ""
            elif n < 20:
                return lessThan20[n] + " "
            elif n < 100:
                return tens[n // 10] + " " + helper(n % 10)
            else:
                return lessThan20[n // 100] + " Hundred " + helper(n % 100)

        res = ""
        for i in range(len(thousands)):
            if num % 1000 != 0:
                res = helper(num % 1000) + thousands[i] + " " + res
            num //= 1000

        return res.strip()


if __name__ == "__main__":
    solution = IntegerToEnglishWords()

    print("Expected Output : One Hundred Twenty Three")
    print("Actual Output : ", solution.numberToWords(123))

    print("Expected Output : Twelve Thousand Three Hundred Forty Five")
    print("Actual Output : ", solution.numberToWords(12345))

    print(
        "Expected Output : One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
    )
    print("Actual Output : ", solution.numberToWords(1234567))
