import random


class RandomizedSet:
    def __init__(self):
        self.list = []
        self.dict = {}

    def insert(self, val: int) -> bool:
        if val in self.dict:
            return False

        self.dict[val] = len(self.list)
        self.list.append(val)
        return True

    def remove(self, val: int) -> bool:
        if val not in self.dict:
            return False

        index = self.dict[val]
        last = self.list[-1]
        self.list[index] = last
        self.dict[last] = index
        self.list.pop()
        del self.dict[val]

        return True

    def getRandom(self) -> int:
        return random.choice(self.list)


if __name__ == "__main__":
    solution = RandomizedSet()
    print("Excepetd Output : True")
    print("Actual Output : ", solution.insert(1))
    print("Excepetd Output : False")
    print("Actual Output : ", solution.remove(2))
    print("Excepetd Output : True")
    print("Actual Output : ", solution.insert(2))
    print("Excepetd Output : 1 or 2")
    print("Actual Output : ", solution.getRandom())
    print("Excepetd Output : True")
    print("Actual Output : ", solution.remove(1))
    print("Excepetd Output : False")
    print("Actual Output : ", solution.insert(2))
