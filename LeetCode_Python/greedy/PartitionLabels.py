class PartitionLabels:
    def partitionLabels(self, s: str) -> list[int]:
        positions = {char: i for i, char in enumerate(s)}
        res = []
        end = point = 0

        for start, char in enumerate(s):
            end = max(end, positions[char])
            if start == end:
                res.append(end - point + 1)
                point = end + 1

        return res


if __name__ == "__main__":
    solution = PartitionLabels()

    print("Expected Output : [9, 7, 8]")
    print("Actual Output   :", solution.partitionLabels("ababcbacadefegdehijhklij"))

    print("Expected Output : [10]")
    print("Actual Output   :", solution.partitionLabels("eccbbbbdec"))
