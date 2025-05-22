class UndergroundSystem:

    def __init__(self):
        self.check_info = {}
        self.times = {}

    def checkIn(self, id: int, stationName: str, t: int) -> None:
        self.check_info[id] = (stationName, t)

    # Time Complexity: O(1)
    # Space Complexity: O(n), n is the number of customers

    def checkOut(self, id: int, stationName: str, t: int) -> None:
        start_station, start_time = self.check_info.pop(id)
        time = t - start_time
        key = (start_station, stationName)
        if key not in self.times:
            self.times[key] = [0, 0]
        self.times[key][0] += time
        self.times[key][1] += 1

    # Time Complexity: O(1)
    # Space Complexity: O(k), k is the number of unique routes

    def getAverageTime(self, startStation: str, endStation: str) -> float:
        total, count = self.times[(startStation, endStation)]
        return total / count

    # Time Complexity: O(1)
    # Space Complexity: O(1)


if __name__ == "__main__":
    solution = UndergroundSystem()

    solution.checkIn(1, "Leyton", 3)
    solution.checkOut(1, "Waterloo", 15)
    print("Expected Output: 12.0")
    print("Actual Output:", solution.getAverageTime("Leyton", "Waterloo"))

    solution.checkIn(2, "Leyton", 10)
    solution.checkOut(2, "Waterloo", 20)
    solution.checkIn(3, "Leyton", 15)
    solution.checkOut(3, "Waterloo", 30)
    print("Expected Output: 12.33")
    print("Actual Output:", solution.getAverageTime("Leyton", "Waterloo"))

    solution.checkIn(4, "Leyton", 8)
    solution.checkOut(4, "Paddington", 20)
    print("Expected Output: 12.0")
    print("Actual Output:", solution.getAverageTime("Leyton", "Paddington"))

    solution.checkIn(5, "Oxford", 5)
    solution.checkOut(5, "Waterloo", 20)
    print("Expected Output: 15.0")
    print("Actual Output:", solution.getAverageTime("Oxford", "Waterloo"))

    solution.checkIn(1, "A", 5)
    solution.checkOut(1, "B", 10)
    solution.checkIn(1, "A", 20)
    solution.checkOut(1, "B", 30)
    print("Expected Output: 7.5")
    print("Actual Output:", solution.getAverageTime("A", "B"))
