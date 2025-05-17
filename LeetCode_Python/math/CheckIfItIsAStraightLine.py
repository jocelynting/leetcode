class CheckIfItIsAStraightLine:
    def checkStraightLine(self, coordinates: list[list[int]]) -> bool:
        x0, y0 = coordinates[0]
        x1, y1 = coordinates[1]

        for x, y in coordinates[2:]:
            if (y - y0) * (x1 - x0) != (x - x0) * (y1 - y0):
                return False

        return True


# Time Complexity: O(n), where n is the number of coordinates
# Space Complexity: O(1), no extra space is used

if __name__ == "__main__":
    solution = CheckIfItIsAStraightLine()

    print("Expected Output: True")
    print(
        "Actual Output: ",
        solution.checkStraightLine([[1, 2], [2, 3], [3, 4], [4, 5], [5, 6]]),
    )

    print("Expected Output: False")
    print(
        "Actual Output: ",
        solution.checkStraightLine([[1, 1], [2, 2], [3, 4], [4, 5], [5, 6]]),
    )

    print("Expected Output: True")
    print("Actual Output: ", solution.checkStraightLine([[0, 0], [0, 1], [0, -1]]))
