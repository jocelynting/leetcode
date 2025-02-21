class Node:
    def __init__(self, key: int, value: int):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None

class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = {}
        self.head = Node(0, 0)
        self.tail = Node(0, 0)
        self.head.next = self.tail
        self.tail.prev = self.head
    
    def remove(self, node: Node) -> None:
        node.prev.next = node.next
        node.next.prev = node.prev

    def add_to_tail(self, node: Node) -> None: 
        tail_prev = self.tail.prev
        tail_prev.next = node
        node.prev = tail_prev
        node.next = self.tail
        self.tail.prev = node

    def get(self, key: int) -> int:
        if key in self.cache:
            node = self.cache[key]
            self.remove(node)
            self.add_to_tail(node)
            return node.value
        return -1
        
    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            node = self.cache[key]
            node.value = value
            self.remove(node)
            self.add_to_tail(node)
        else:
            new_node = Node(key, value)
            self.cache[key] = new_node
            self.add_to_tail(new_node)
            if len(self.cache) > self.capacity:
                lru = self.head.next
                self.remove(lru)
                del self.cache[lru.key]

if __name__ == '__main__':
    cache = LRUCache(2)
    cache.put(1, 1)
    cache.put(2, 2)
    print("get(1): Expected output 1, Actual output:", cache.get(1))
    cache.put(3, 3)  # This should evict key 1 (if we use head insertion) or key 2 (if tail insertion)
    print("get(2): Expected output -1 (if key 2 is evicted) or 2 otherwise, Actual output:", cache.get(2))
    cache.put(4, 4)
    print("get(1): Expected output -1, Actual output:", cache.get(1))
    print("get(3): Expected output 3, Actual output:", cache.get(3))
    print("get(4): Expected output 4, Actual output:", cache.get(4))