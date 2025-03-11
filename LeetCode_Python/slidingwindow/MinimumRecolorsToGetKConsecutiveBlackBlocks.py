class MinimumRecolorsToGetKConsecutiveBlackBlocks:
    def minimumRecolors(self, blocks: str, k: int) -> int:
        left = right = 0
        res = float("inf")
        white = 0

        while right < len(blocks):
            if blocks[right] == "W":
                white += 1

            if right - left + 1 == k:
                res = min(res, white)

                if blocks[left] == "W":
                    white -= 1
                left += 1

            right += 1

        return res


if __name__ == "__main__":
    solution = MinimumRecolorsToGetKConsecutiveBlackBlocks()

    print("Expected Output : 3")
    print("Actual Output : ", solution.minimumRecolors("WBBWWBBWBW", 7))

    print("Expected Output : 0")
    print("Actual Output : ", solution.minimumRecolors("WBWBBBW", 2))

    print("Expected Output : 6")
    print(
        "Actual Output : ",
        solution.minimumRecolors("WBBWWWWBBWWBBBBWWBBWWBBBWWBBBWWWBWBWW", 15),
    )
