class Node:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class MyLinkedList:

    def __init__(self):
        self.head = Node(-1)
        self.size = 0

    def get(self, index: int) -> int:
        if index < 0 or index >= self.size:
            return -1

        cur = self.head
        for _ in range(index + 1):
            cur = cur.next
        return cur.val

    def addAtHead(self, val: int) -> None:
        self.addAtIndex(0, val)

    def addAtTail(self, val: int) -> None:
        self.addAtIndex(self.size, val)

    def addAtIndex(self, index: int, val: int) -> None:
        if index < 0 or index > self.size:
            return

        cur = self.head
        for _ in range(index):
            cur = cur.next

        new_node = Node(val)
        new_node.next = cur.next
        cur.next = new_node
        self.size += 1

    def deleteAtIndex(self, index: int) -> None:
        if index < 0 or index >= self.size:
            return

        cur = self.head
        for _ in range(index):
            cur = cur.next
        cur.next = cur.next.next
        self.size -= 1


# Time Complexity:
# get: O(n), where n is the index
# addAtHead: O(1)
# addAtTail: O(n), where n is the size of the linked list
# addAtIndex: O(n), where n is the index
# deleteAtIndex: O(n), where n is the index
# Space Complexity: O(n), where n is the size of the linked list


class ListNode:
    def __init__(self, val):
        self.val = val
        self.prev = None
        self.next = None


class MyLinkedListByDLL:
    def __init__(self):
        self.head = ListNode(-1)
        self.tail = ListNode(-1)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.size = 0

    def get_node(self, index: int) -> ListNode:
        if index + 1 < self.size - index:
            cur = self.head
            for _ in range(index + 1):
                cur = cur.next
        else:
            cur = self.tail
            for _ in range(self.size - index):
                cur = cur.prev
        return cur

    def get(self, index: int) -> int:
        if index < 0 or index >= self.size:
            return -1
        return self.get_node(index).val

    def addAtHead(self, val: int) -> None:
        self.addAtIndex(0, val)

    def addAtTail(self, val: int) -> None:
        self.addAtIndex(self.size, val)

    def addAtIndex(self, index: int, val: int) -> None:
        if index < 0 or index > self.size:
            return

        node = self.get_node(index)
        new_node = ListNode(val)
        new_node.prev = node.prev
        new_node.next = node
        node.prev.next = new_node
        node.prev = new_node
        self.size += 1

    def deleteAtIndex(self, index: int) -> None:
        if index < 0 or index >= self.size:
            return

        node = self.get_node(index)
        node.prev.next = node.next
        node.next.prev = node.prev
        self.size -= 1


# Time Complexity:
# get: O(min(index, n−index)), because we can traverse from either the head or the tail
# addAtHead: O(1)
# addAtTail: O(1)
# addAtIndex: O(min(index, n−index)), because we can traverse from either the head or the tail
# deleteAtIndex: O(min(index, n−index)), because we can traverse from either the head or the tail
# Space Complexity: O(n), where n is the size of the linked list


if __name__ == "__main__":
    solution = MyLinkedList()

    solution.addAtHead(1)
    solution.addAtTail(3)
    print("Expected Output: 1")
    print("Actual Output:", solution.get(0))

    print("Expected Output: 3")
    print("Actual Output:", solution.get(1))

    solution.addAtIndex(1, 2)
    print("Expected Output: 2")
    print("Actual Output:", solution.get(1))

    solution.deleteAtIndex(1)
    print("Expected Output: 3")
    print("Actual Output:", solution.get(1))

    solution2 = MyLinkedListByDLL()

    solution2.addAtHead(1)
    solution2.addAtTail(3)
    print("Expected Output: 1")
    print("Actual Output:", solution2.get(0))

    print("Expected Output: 3")
    print("Actual Output:", solution2.get(1))

    solution2.addAtIndex(1, 2)
    print("Expected Output: 2")
    print("Actual Output:", solution2.get(1))

    solution2.deleteAtIndex(1)
    print("Expected Output: 3")
    print("Actual Output:", solution2.get(1))
