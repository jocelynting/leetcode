class CarPooling:
    def carPooling(self, trips: list[list[int]], capacity: int) -> bool:
        events = []

        for passengers, start, end in trips:
            events.append((start, passengers))
            events.append((end, -passengers))

        events.sort()

        current_capacity = 0

        for _, passengers in events:
            current_capacity += passengers
            if current_capacity > capacity:
                return False

        return True


# Time Complexity: O(nlogn)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = CarPooling()

    print("Expected Output : False")
    print("Actual Output : ", solution.carPooling([[2, 1, 5], [3, 3, 7]], 4))

    print("Expected Output : True")
    print("Actual Output : ", solution.carPooling([[2, 1, 5], [3, 3, 7]], 5))

    print("Expected Output : True")
    print("Actual Output : ", solution.carPooling([[2, 1, 5], [3, 5, 7]], 3))
