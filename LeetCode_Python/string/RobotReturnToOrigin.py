class RobotReturnToOrigin:
    def judgeCircle(self, moves: str) -> bool:
        return moves.count("U") == moves.count("D") and moves.count("L") == moves.count(
            "R"
        )


# Time Complexity : O(n), where n is the length of the moves string.
# Space Complexity : O(1), as we are using a constant amount of space.


if __name__ == "__main__":
    solution = RobotReturnToOrigin()

    print("Expected Output : True")
    print("Actual Output : ", solution.judgeCircle("UD"))

    print("Expected Output : False")
    print("Actual Output : ", solution.judgeCircle("LL"))

    print("Expected Output : False")
    print("Actual Output : ", solution.judgeCircle("RRDD"))
