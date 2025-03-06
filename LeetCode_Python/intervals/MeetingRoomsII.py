import heapq


class MeetingRoomsII:
    def minMeetingRooms(self, intervals: list[list[int]]) -> int:
        intervals.sort(key=lambda a: a[0])

        heap = [intervals[0][1]]

        for i in range(1, len(intervals)):
            if intervals[i][0] >= heap[0]:
                heapq.heappop(heap)
            heapq.heappush(heap, intervals[i][1])

        return len(heap)


if __name__ == "__main__":
    solution = MeetingRoomsII()

    print("Expected Output : 2")
    print("Actual Output : ", solution.minMeetingRooms([[0, 30], [5, 10], [15, 20]]))

    print("Expected Output : 1")
    print("Actual Output : ", solution.minMeetingRooms([[7, 10], [2, 4]]))

    print("Expected Output : 2")
    print(
        "Actual Output : ",
        solution.minMeetingRooms([[0, 30], [5, 10], [15, 20], [10, 15]]),
    )
