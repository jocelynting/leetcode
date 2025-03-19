from typing import Optional
from ListNode import ListNode


class IntersectionOfTwoLinkedLists:
    def getIntersectionNode(
        self, headA: ListNode, headB: ListNode
    ) -> Optional[ListNode]:
        p1, p2 = headA, headB

        while p1 != p2:
            p1 = p1.next if p1 else headB
            p2 = p2.next if p2 else headA

        return p1


if __name__ == "__main__":
    solution = IntersectionOfTwoLinkedLists()

    headA = ListNode(4)
    headA.next = ListNode(1)
    headA.next.next = ListNode(8)
    headA.next.next.next = ListNode(4)
    headA.next.next.next.next = ListNode(5)

    headB = ListNode(5)
    headB.next = ListNode(0)
    headB.next.next = ListNode(1)
    headB.next.next.next = headA.next.next

    print("Expected Output: 8")
    print("Actual Output:", solution.getIntersectionNode(headA, headB).val)
