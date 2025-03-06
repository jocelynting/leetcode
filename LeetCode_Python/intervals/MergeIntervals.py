class MergeIntervals:
    def merge(self, intervals: list[list[int]]) -> list[list[int]]:
        intervals.sort(key=lambda a: a[0])
        res = []

        for i in range(len(intervals)):
            if not res or intervals[i][0] > res[-1][1]:
                res.append(intervals[i])
            else:
                res[-1][1] = max(res[-1][1], intervals[i][1])

        return res


if __name__ == "__main__":
    solution = MergeIntervals()

    print("Expected Output : [[1,6],[8,10],[15,18]]")
    print("Actual Output : ", solution.merge([[1, 3], [2, 6], [8, 10], [15, 18]]))

    print("Expected Output : [[1,5]]")
    print("Actual Output : ", solution.merge([[1, 4], [4, 5]]))
