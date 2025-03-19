class NonOverlappingIntervals:
    def eraseOverlapIntervals(self, intervals: list[list[int]]) -> int:
        intervals.sort(key=lambda x: x[1])

        res = 0
        end = intervals[0][1]

        for i in range(1, len(intervals)):
            if intervals[i][0] < end:
                res += 1
            else:
                end = intervals[i][1]

        return res


if __name__ == "__main__":
    solution = NonOverlappingIntervals()

    print("Expected Output: 1")
    print(
        "Actual Output: ",
        solution.eraseOverlapIntervals([[1, 2], [2, 3], [3, 4], [1, 3]]),
    )

    print("Expected Output: 2")
    print("Actual Output: ", solution.eraseOverlapIntervals([[1, 2], [1, 2], [1, 2]]))

    print("Expected Output: 0")
    print("Actual Output: ", solution.eraseOverlapIntervals([[1, 2], [2, 3]]))
