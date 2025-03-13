class BoatsToSavePeople:
    def numRescueBoats(self, people: list[int], limit: int) -> int:
        people.sort()
        left, right = 0, len(people) - 1

        res = 0

        while left <= right:
            if people[left] + people[right] <= limit:
                left += 1
            right -= 1
            res += 1

        return res


if __name__ == "__main__":
    solution = BoatsToSavePeople()

    print("Expected Output : 1")
    print("Actual Output : ", solution.numRescueBoats([1, 2], 3))

    print("Expected Output : 3")
    print("Actual Output : ", solution.numRescueBoats([3, 2, 2, 1], 3))

    print("Expected Output : 4")
    print("Actual Output : ", solution.numRescueBoats([3, 5, 3, 4], 5))
