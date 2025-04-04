class TimeMap:
    def __init__(self):
        self.time_map = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.time_map:
            self.time_map[key] = []
        self.time_map[key].append((timestamp, value))

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.time_map:
            return ""

        values = self.time_map[key]
        left, right = 0, len(values)

        while left < right:
            mid = left + (right - left) // 2
            if values[mid][0] <= timestamp:
                left = mid + 1
            else:
                right = mid

        return values[right - 1][1] if right > 0 else ""


# Time Complexity: O(log n) for get, O(1) for set
# Space Complexity: O(n) for storing the values

if __name__ == "__main__":
    solution = TimeMap()
    solution.set("foo", "bar", 1)

    print("Expected Output: bar")
    print("Actual Output:", solution.get("foo", 1))

    print("Expected Output: bar")
    print("Actual Output:", solution.get("foo", 3))

    solution.set("foo", "bar2", 4)

    print("Expected Output: bar2")
    print("Actual Output:", solution.get("foo", 4))

    print("Expected Output: bar2")
    print("Actual Output:", solution.get("foo", 5))
