class RowWithMaximumOnes:
    def rowAndMaximumOnes(self, mat: list[list[int]]) -> list[int]:
        count = [row.count(1) for row in mat]
        return [count.index(max(count)), max(count)]


# Time: O(n*m)
# Space: O(n)

if __name__ == "__main__":
    solution = RowWithMaximumOnes()

    print("Expected Output: [2, 4] ")
    print(
        "Actual Output: ",
        solution.rowAndMaximumOnes([[0, 1, 1, 1], [0, 0, 0, 0], [1, 1, 1, 1]]),
    )

    print("Expected Output: [0, 4] ")
    print(
        "Actual Output: ",
        solution.rowAndMaximumOnes([[1, 1, 1, 1], [0, 0, 0, 0], [1, 1, 1, 0]]),
    )

    print("Expected Output: [0, 1] ")
    print(
        "Actual Output: ",
        solution.rowAndMaximumOnes([[0, 0, 0, 0], [0, 0, 0, 0], [1, 1, 1, 0]]),
    )
