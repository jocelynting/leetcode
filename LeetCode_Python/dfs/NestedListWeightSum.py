from typing import Union


class NestedInteger:
    def __init__(self, value: Union[int, list["NestedInteger"]] = None):
        if isinstance(value, int):
            self._integer = value
            self._list = None
        else:
            self._integer = None
            self._list = value if value is not None else []

    def isInteger(self) -> bool:
        return self._integer is not None

    def getInteger(self) -> Union[int, None]:
        return self._integer

    def getList(self) -> list["NestedInteger"]:
        return self._list

    def __repr__(self):
        if self.isInteger():
            return str(self._integer)
        return str(self._list)


class NestedListWeightSum:
    def depthSum(self, nestedList: list[NestedInteger]) -> int:
        def dfs(nList: list[NestedInteger], depth: int) -> int:
            total = 0
            for ni in nList:
                if ni.isInteger():
                    total += ni.getInteger() * depth
                else:
                    total += dfs(ni.getList(), depth + 1)
            return total

        return dfs(nestedList, 1)


if __name__ == "__main__":
    solution = NestedListWeightSum()

    nestedList1 = [
        NestedInteger([NestedInteger(1), NestedInteger(1)]),
        NestedInteger(2),
        NestedInteger([NestedInteger(1), NestedInteger(1)]),
    ]
    print("Expected Output:", 10)
    print("Actual Output:", solution.depthSum(nestedList1))

    nestedList2 = [
        NestedInteger(1),
        NestedInteger([NestedInteger(4), NestedInteger([NestedInteger(6)])]),
    ]
    print("Expected Output:", 27)
    print("Actual Output:", solution.depthSum(nestedList2))
