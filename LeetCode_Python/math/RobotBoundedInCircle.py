class RobotBoundedInCircle:
    def isRobotBounded(self, instructions: str) -> bool:
        # north = 0, east = 1, south = 2, west = 3
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        x, y = 0, 0
        d = 0

        for i in instructions:
            if i == "L":
                d = (d + 3) % 4
            elif i == "R":
                d = (d + 1) % 4
            else:
                dx, dy = directions[d]
                x += dx
                y += dy

        return (x == 0 and y == 0) or d != 0


# Time Complexity: O(n), where n is the length of the instructions string.
# Space Complexity: O(1), since we are using a fixed amount of space for x, y, and d.


if __name__ == "__main__":
    solution = RobotBoundedInCircle()

    print("Expected Output: True")
    print("Actual Output:", solution.isRobotBounded("GGLLGG"))

    print("Expected Output: False")
    print("Actual Output:", solution.isRobotBounded("GLGLGGLGL"))

    print("Expected Output: True")
    print("Actual Output:", solution.isRobotBounded("GLGLGGLGLGLGGLGLG"))
