class IntervalListIntersections:
    def intervalIntersection(
        self, firstList: list[list[int]], secondList: list[list[int]]
    ) -> list[list[int]]:
        i, j = 0, 0
        res = []
        while i < len(firstList) and j < len(secondList):
            s1, e1 = firstList[i]
            s2, e2 = secondList[j]

            start = max(s1, s2)
            end = min(e1, e2)

            if start <= end:
                res.append([start, end])

            if e1 < e2:
                i += 1
            else:
                j += 1

        return res


# Time Complexity: O(m + n)
# Space Complexity: O(m + n)

if __name__ == "__main__":
    solution = IntervalListIntersections()

    firstList1 = [[0, 2], [5, 10], [13, 23], [24, 25]]
    secondList1 = [[1, 5], [8, 12], [15, 24], [25, 26]]
    print("Expected Output: [[1, 2], [5, 5], [8, 10], [15, 23], [24, 24], [25, 25]]")
    print("Actual Output:", solution.intervalIntersection(firstList1, secondList1))

    firstList2 = [[1, 3], [5, 9]]
    secondList2 = []
    print("Expected Output: []")
    print("Actual Output:", solution.intervalIntersection(firstList2, secondList2))
