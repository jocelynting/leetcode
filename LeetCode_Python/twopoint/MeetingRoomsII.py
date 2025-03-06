import heapq


class MeetingRoomsII:
    def minMeetingRooms(self, intervals: list[list[int]]) -> int:

        starts = sorted(interval[0] for interval in intervals)
        ends = sorted(interval[1] for interval in intervals)

        s, e = 0, 0
        room = 0
        res = 0

        while s < len(intervals):
            if starts[s] < ends[e]:
                room += 1
                s += 1
                res = max(res, room)
            else:
                room -= 1
                e += 1

        return res


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
