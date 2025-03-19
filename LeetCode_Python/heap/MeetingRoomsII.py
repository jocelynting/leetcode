import heapq


class MeetingRoomsII:
    def minMeetingRooms(self, intervals: list[list[int]]) -> int:

        intervals.sort(key=lambda x: x[0])

        heap = []

        for start, end in intervals:
            if heap and heap[0] <= start:
                heapq.heappop(heap)

            heapq.heappush(heap, end)

        return len(heap)


# Time Complexity: O(NlogN)
# Space Complexity: O(N)


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
