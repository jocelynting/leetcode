class MaximumUnitsOnATruck:
    def maximumUnits(self, boxTypes: list[list[int]], truckSize: int) -> int:
        boxTypes.sort(key=lambda x: x[1], reverse=True)

        res = 0
        index = 0

        for boxes, units in boxTypes:
            if truckSize == 0:
                break
            count = min(truckSize, boxes)
            res += count * units
            truckSize -= count

        return res


if __name__ == "__main__":
    solution = MaximumUnitsOnATruck()

    print("Expected Output: 8")
    print("Actual Output:", solution.maximumUnits([[1, 3], [2, 2], [3, 1]], 4))

    print("Expected Output: 91")
    print(
        "Actual Output:", solution.maximumUnits([[5, 10], [2, 5], [4, 7], [3, 9]], 10)
    )
