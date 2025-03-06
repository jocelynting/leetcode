class LetterCombinationsOfPhoneNumber:
    def letterCombinations(self, digits: str) -> list[str]:
        if not digits:
            return []

        dic = {
            "2": "abc",
            "3": "def",
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "pqrs",
            "8": "tuv",
            "9": "wxyz",
        }
        res = []
        path = []

        def backtracking(index: int) -> None:
            if index == len(digits):
                res.append("".join(path))
                return

            letters = dic[digits[index]]
            for l in letters:
                path.append(l)
                backtracking(index + 1)
                path.pop()

        backtracking(0)

        return res


if __name__ == "__main__":
    solution = LetterCombinationsOfPhoneNumber()

    print('Expected Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]')
    print("Actual Output:", solution.letterCombinations("23"))

    print('Expected Output: ["a","b","c"]')
    print("Actual Output:", solution.letterCombinations("2"))
