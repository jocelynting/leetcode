from collections import deque


class Dota2Senate:
    def predictPartyVictory(self, senate: str) -> str:
        n = len(senate)
        queue_r = deque()
        queue_d = deque()

        for i, s in enumerate(senate):
            if s == "R":
                queue_r.append(i)
            else:
                queue_d.append(i)

        while queue_r and queue_d:
            r = queue_r.popleft()
            d = queue_d.popleft()

            if r < d:
                queue_r.append(r + n)
            else:
                queue_d.append(d + n)

        return "Radiant" if queue_r else "Dire"


# Time Complexity: O(n), where n is the length of the senate string.
# Space Complexity: O(n), for the two queues used to store the indices of the senators.

if __name__ == "__main__":
    solution = Dota2Senate()

    print("Expected Output: Radiant")
    print("Actual Output:", solution.predictPartyVictory("RD"))

    print("Expected Output: Dire")
    print("Actual Output:", solution.predictPartyVictory("RDD"))
