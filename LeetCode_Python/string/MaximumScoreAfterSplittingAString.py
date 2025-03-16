class MaximumScoreAfterSplittingAString:
    def maxScore(self, s: str) -> int:
        res = 0
        ones = s.count("1")
        zeros = 0

        for i in range(len(s) - 1):
            if s[i] == "0":
                zeros += 1
            else:
                ones -= 1
            res = max(res, zeros + ones)

        return res


if __name__ == "__main__":
    solution = MaximumScoreAfterSplittingAString()

    print("Expected Output: 5")
    print("Actual Output:", solution.maxScore("011101"))

    print("Expected Output: 5")
    print("Actual Output:", solution.maxScore("00111"))

    print("Expected Output: 3")
    print("Actual Output:", solution.maxScore("1111"))
