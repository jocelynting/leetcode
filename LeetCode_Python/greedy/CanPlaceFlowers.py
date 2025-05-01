class CanPlaceFlowers:
    def canPlaceFlowers(self, flowerbed: list[int], n: int) -> bool:
        count = 0
        i = 0

        while i < len(flowerbed):
            if (
                flowerbed[i] == 0
                and (i == 0 or flowerbed[i - 1] == 0)
                and (i == len(flowerbed) - 1 or flowerbed[i + 1] == 0)
            ):
                flowerbed[i] = 1
                count += 1
            i += 1

        return count >= n


# Time Complexity: O(n), where n is the length of the flowerbed
# Space Complexity: O(1), we are not using any extra space that grows with the input size

if __name__ == "__main__":
    solution = CanPlaceFlowers()

    print("Expected Output : True")
    print("Actual Output : ", solution.canPlaceFlowers([1, 0, 0, 0, 1], 1))

    print("Expected Output : False")
    print("Actual Output : ", solution.canPlaceFlowers([1, 0, 0, 0, 1], 2))
