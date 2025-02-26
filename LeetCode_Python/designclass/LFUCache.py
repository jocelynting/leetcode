class Node:
    def __init__(self, key: int, value: int):
        self.key = key
        self.value = value
        self.freq = 1
        self.prev = None
        self.next = None

class DoubleLinkedList:
    def __init__(self):
        self.head = Node(0, 0)
        self.tail = Node(0, 0)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.size = 0
    
    def remove_node(self, node: Node) -> None:
        node.prev.next = node.next
        node.next.prev = node.prev
        self.size -= 1
    
    def add_node(self, node: Node) -> None:
        tail_prev = self.tail.prev
        tail_prev.next = node
        node.prev = tail_prev
        node.next = self.tail
        self.tail.prev = node
        self.size += 1
    
    def remove_head(self) -> None:
        if self.size == 0:
            return None
        node = self.head.next
        self.remove_node(node)
        return node

class LFUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.min_freq = 0
        self.cache = {}
        self.freq_table = {}

    def update(self, node: Node) -> None:
        freq = node.freq
        self.freq_table[freq].remove_node(node)
        if freq == self.min_freq and self.freq_table[freq].size == 0:
            self.min_freq += 1
        node.freq += 1
        new_freq = node.freq
        if new_freq not in self.freq_table:
            self.freq_table[new_freq] = DoubleLinkedList()
        self.freq_table[new_freq].add_node(node)

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        node = self.cache[key]
        self.update(node)
        return node.value

    def put(self, key: int, value: int) -> None:
        if self.capacity == 0:
            return
        if key in self.cache:
            node = self.cache[key]
            node.value= value
            self.update(node)
        else:
            if len(self.cache) >= self.capacity:
                node_list = self.freq_table[self.min_freq]
                node_remove = node_list.remove_head()
                if node_remove:
                    del self.cache[node_remove.key]
            node = Node(key, value)
            self.cache[key] = node
            self.min_freq = 1
            if 1 not in self.freq_table:
                self.freq_table[1] = DoubleLinkedList()
            self.freq_table[1].add_node(node)

if __name__ == '__main__':
    cache = LFUCache(2)
    cache.put(1, 1)
    cache.put(2, 2)
    print("get(1): Expected output 1, Actual output:", cache.get(1))  # returns 1
    cache.put(3, 3)  # evicts key 2 because key 2 has freq 1 and key 1 has freq 2 now
    print("get(2): Expected output -1, Actual output:", cache.get(2))  # returns -1
    print("get(3): Expected output 3, Actual output:", cache.get(3))  # returns 3
    cache.put(4, 4)  # evicts key 3 because key 3 and key 1 both freq 2, but key 3 is LRU in freq 2 list
    print("get(1): Expected output 1, Actual output:", cache.get(1))  # returns 1 or may vary based on internal order
    print("get(3): Expected output -1, Actual output:", cache.get(3))  # returns -1
    print("get(4): Expected output 4, Actual output:", cache.get(4))  # returns 4

    cache2 = LFUCache(0)
    cache2.put(1, 1)
    print("get(1): Expected output -1, Actual output:", cache2.get(1))