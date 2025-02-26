class Node:
    def __init__(self, val: int = 0, neighbors: list['Node'] = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []