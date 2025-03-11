class MaxChunksToMakeSorted:
    def maxChunksToSorted(self, arr: list[int]) -> int:
        res = 0
        max_num = 0

        for i in range(len(arr)):
            max_num = max(max_num, arr[i])
            if max_num == i:
                res += 1

        return res


if __name__ == "__main__":
    solution = MaxChunksToMakeSorted()

    print("Expected Output : 1")
    print("Actual Output : ", solution.maxChunksToSorted([4, 3, 2, 1, 0]))

    print("Expected Output : 4")
    print("Actual Output : ", solution.maxChunksToSorted([1, 0, 2, 3, 4]))
