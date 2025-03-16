class PascalTriangleII:
    def getRow(self, rowIndex: int) -> list[int]:
        res = [1]

        for i in range(1, rowIndex + 1):
            cur = [1] * (i + 1)
            for j in range(1, i):
                cur[j] = res[j] + res[j - 1]
            res = cur

        return res


if __name__ == "__main__":
    solution = PascalTriangleII()

    print("Expected Output : [1,3,3,1]")
    print("Actual Output   :", solution.getRow(3))

    print("Expected Output : [1]")
    print("Actual Output   :", solution.getRow(0))

    print("Expected Output : [1,1]")
    print("Actual Output   :", solution.getRow(1))
