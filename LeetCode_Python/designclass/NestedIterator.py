class NestedInteger:
    def __init__(self, value):
        if isinstance(value, int):
            self._integer = value
            self._list = None
        elif isinstance(value, list):
            self._integer = None
            self._list = []
            for item in value:
                if isinstance(item, NestedInteger):
                    self._list.append(item)
                else:
                    self._list.append(NestedInteger(item))

    def isInteger(self):
        return self._integer is not None

    def getInteger(self):
        return self._integer

    def getList(self):
        return self._list


class NestedIterator:
    def __init__(self, nestedList: list[NestedInteger]):
        self.stack = []

        for item in reversed(nestedList):
            self.stack.append(item)

    def next(self) -> int:
        if self.hasNext():
            return self.stack.pop().getInteger()

    def hasNext(self) -> bool:
        while self.stack:
            top = self.stack[-1]
            if top.isInteger():
                return True
            nest_list = self.stack.pop().getList()
            if nest_list:
                for item in reversed(nest_list):
                    self.stack.append(item)
        return False


if __name__ == "__main__":
    nestedList = [
        NestedInteger([NestedInteger(1), NestedInteger(1)]),
        NestedInteger(2),
        NestedInteger([NestedInteger(1), NestedInteger(1)]),
    ]

    i, v = NestedIterator(nestedList), []
    while i.hasNext():
        v.append(i.next())

    print("Expected Output: [1, 1, 2, 1, 1]")
    print("Actual Output:", v)

    nestedList2 = [
        NestedInteger(1),
        NestedInteger([NestedInteger(4), NestedInteger([NestedInteger(6)])]),
    ]
    i, v = NestedIterator(nestedList2), []
    while i.hasNext():
        v.append(i.next())
    print("Expected Output: [1, 4, 6]")
    print("Actual Output:", v)
