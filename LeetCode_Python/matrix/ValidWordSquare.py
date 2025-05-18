class ValidWordSquare:
    def validWordSquare(self, words: list[str]) -> bool:
        n = len(words)

        for i in range(n):
            for j in range(len(words[i])):
                if j >= n or i >= len(words[j]) or words[i][j] != words[j][i]:
                    return False

        return True


# Time Complexity: O(n^2), where n is the number of words in the list.
# Space Complexity: O(1), since we are using a fixed amount of space for the variables.

if __name__ == "__main__":
    solution = ValidWordSquare()

    print("Expected Output: True")
    print("Actual Output:", solution.validWordSquare(["abcd", "bnrt", "crmy", "dtye"]))

    print("Expected Output: True")
    print("Actual Output:", solution.validWordSquare(["abcd", "bnrt", "crm", "dt"]))

    print("Expected Output: False")
    print("Actual Output:", solution.validWordSquare(["ball", "area", "read", "lady"]))
