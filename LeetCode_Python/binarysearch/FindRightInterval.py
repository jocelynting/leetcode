class FindRightInterval:
    def findRightInterval(self, intervals):
        n = len(intervals)
        starts = [(intervals[i][0], i) for i in range(n)]
        starts.sort()

        def binarySearch(target):
            left, right = 0, n

            while left < right:
                mid = left + (right - left) // 2
                if starts[mid][0] < target:
                    left = mid + 1
                else:
                    right = mid

            return left if left < n else -1

        res = []
        for interval in intervals:
            index = binarySearch(interval[1])
            if index == -1:
                res.append(-1)
            else:
                res.append(starts[index][1])

        return res


# Time Complexity: O(n log n), where n is the number of intervals, due to sorting and binary search.
# Space Complexity: O(n), for storing the starts list.

if __name__ == "__main__":
    solution = FindRightInterval()

    print("Expected Output: [-1]")
    print("Actual Output:", solution.findRightInterval([[1, 2]]))

    print("Expected Output: [-1, 0, 1]")
    print("Actual Output:", solution.findRightInterval([[3, 4], [2, 3], [1, 2]]))

    print("Expected Output: [-1, 2, -1]")
    print("Actual Output:", solution.findRightInterval([[1, 4], [2, 3], [3, 4]]))
