class KeysAndRooms:
    def canVisitAllRooms(self, rooms: list[list[int]]) -> bool:
        n = len(rooms)
        visited = set()

        def dfs(room):
            visited.add(room)

            for nei in rooms[room]:
                if nei not in visited:
                    dfs(nei)

        dfs(0)
        return len(visited) == n

    # Time Comeplexity: O(V + E), where V is the number of rooms and E is the number of keys
    # Space Complexity: O(V), for the visited set

    def canVisitAllRoomsByBFS(self, rooms: list[list[int]]) -> bool:
        n = len(rooms)
        visited = set()
        queue = [0]

        while queue:
            room = queue.pop(0)
            visited.add(room)

            for nei in rooms[room]:
                if nei not in visited:
                    queue.append(nei)

        return len(visited) == n

    # Time Comeplexity: O(V + E), where V is the number of rooms and E is the number of keys
    # Space Complexity: O(V), for the visited set and queue


if __name__ == "__main__":
    solution = KeysAndRooms()

    rooms = [[1], [2], [3], []]
    print("Expected Output: True")
    print("Actual Output:", solution.canVisitAllRooms(rooms))
    print("Actual Output:", solution.canVisitAllRoomsByBFS(rooms))

    rooms = [[1, 3], [3, 0, 1], [2], [0]]
    print("Expected Output: False")
    print("Actual Output:", solution.canVisitAllRooms(rooms))
    print("Actual Output:", solution.canVisitAllRoomsByBFS(rooms))
