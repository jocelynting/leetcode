from typing import Optional
from ListNode import ListNode
import heapq


class MergeKSortedLists:
    def mergeKLists(self, lists: list[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists or len(lists) == 0:
            return None

        def merge(l1: ListNode, l2: ListNode) -> ListNode:
            dummy = ListNode()
            cur = dummy

            while l1 and l2:
                if l1.val < l2.val:
                    cur.next = l1
                    l1 = l1.next
                else:
                    cur.next = l2
                    l2 = l2.next
                cur = cur.next

            cur.next = l1 if l1 else l2

            return dummy.next

        def divide(left: int, right: int) -> ListNode:
            if left == right:
                return lists[left]

            mid = left + (right - left) // 2
            l1 = divide(left, mid)
            l2 = divide(mid + 1, right)

            return merge(l1, l2)

        return divide(0, len(lists) - 1)

    def mergeKListsByHeap(self, lists: list[Optional[ListNode]]) -> Optional[ListNode]:
        heap = []
        count = 0

        for node in lists:
            if node:
                heapq.heappush(heap, (node.val, count, node))
                count += 1

        dummy = ListNode()
        cur = dummy

        while heap:
            _, _, node = heapq.heappop(heap)
            cur.next = node
            cur = cur.next

            if node.next:
                heapq.heappush(heap, (node.next.val, count, node.next))
                count += 1

        return dummy.next


if __name__ == "__main__":
    solution = MergeKSortedLists()

    l1 = ListNode(1, ListNode(4, ListNode(5)))
    l2 = ListNode(1, ListNode(3, ListNode(4)))
    l3 = ListNode(2, ListNode(6))
    lists = [l1, l2, l3]
    print("Expected Output : 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6")

    result = solution.mergeKLists(lists)
    print("Actual Output : ")
    while result:
        if not result.next:
            print(result.val)
        else:
            print(result.val, end=" -> ")
        result = result.next

    l1 = ListNode(1, ListNode(4, ListNode(5)))
    l2 = ListNode(1, ListNode(3, ListNode(4)))
    l3 = ListNode(2, ListNode(6))
    lists = [l1, l2, l3]
    result = solution.mergeKListsByHeap(lists)
    print("Actual Output : ")
    while result:
        if not result.next:
            print(result.val)
        else:
            print(result.val, end=" -> ")
        result = result.next
