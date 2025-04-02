class InsertInterval:
    def insert(
        self, intervals: list[list[int]], newInterval: list[int]
    ) -> list[list[int]]:
        left, right = 0, len(intervals)

        while left < right:
            mid = (left + right) // 2
            if intervals[mid][0] < newInterval[0]:
                left = mid + 1
            else:
                right = mid

        intervals.insert(left, newInterval)

        res = []

        for interval in intervals:
            if not res or res[-1][1] < interval[0]:
                res.append(interval)
            else:
                res[-1][1] = max(res[-1][1], interval[1])

        return res


# Time Complexity: O(n), binary search takes O(log n) and merging intervals takes O(n), so the overall time complexity is O(n)
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
