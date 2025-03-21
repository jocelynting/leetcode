import heapq


class CarPooling:
    def carPooling(self, trips: list[list[int]], capacity: int) -> bool:
        trips.sort(key=lambda x: x[1])

        heap = []
        current_capacity = 0

        for num_passengers, start_location, end_location in trips:
            while heap and heap[0][0] <= start_location:
                current_capacity -= heap[0][1]
                heapq.heappop(heap)

            current_capacity += num_passengers
            heapq.heappush(heap, (end_location, num_passengers))

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
