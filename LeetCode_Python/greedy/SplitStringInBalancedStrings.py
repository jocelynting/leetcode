class SplitStringInBalancedStrings:
    def balancedStringSplit(self, s: str) -> int:
        balance, res = 0, 0

        for ch in s:
            if ch == "R":
                balance += 1
            else:
                balance -= 1

            if balance == 0:
                res += 1

        return res


if __name__ == "__main__":
    solution = SplitStringInBalancedStrings()

    print("Expected Output: 4")
    print("Actual Output:", solution.balancedStringSplit("RLRRLLRLRL"))

    print("Expected Output: 3")
    print("Actual Output:", solution.balancedStringSplit("RLLLLRRRLR"))

    print("Expected Output: 1")
    print("Actual Output:", solution.balancedStringSplit("LLLLRRRR"))
