class InsertInterval:
    def insert(
        self, intervals: list[list[int]], newInterval: list[int]
    ) -> list[list[int]]:
        res = []
        i, n = 0, len(intervals)

        while i < n and intervals[i][1] < newInterval[0]:
            res.append(intervals[i])
            i += 1

        while i < n and intervals[i][0] <= newInterval[1]:
            newInterval[0] = min(newInterval[0], intervals[i][0])
            newInterval[1] = max(newInterval[1], intervals[i][1])
            i += 1
        res.append(newInterval)

        while i < n:
            res.append(intervals[i])
            i += 1

        return res


# Time Complexity: O(n)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = InsertInterval()
    intervals = [[1, 3], [6, 9]]
    newInterval = [2, 5]
    print("Expected Output: [[1, 5], [6, 9]]")
    print("Actual Output:", solution.insert(intervals, newInterval))

    intervals = [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]]
    newInterval = [4, 8]
    print("Expected Output: [[1, 2], [3, 10], [12, 16]]")
    print("Actual Output:", solution.insert(intervals, newInterval))
