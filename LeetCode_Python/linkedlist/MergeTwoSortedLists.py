from typing import Optional
from ListNode import ListNode


class MergeTwoSortedLists:
    def mergeTwoLists(
        self, list1: Optional[ListNode], list2: Optional[ListNode]
    ) -> Optional[ListNode]:
        if not list1:
            return list2
        if not list2:
            return list1

        dummy = ListNode(0)
        cur = dummy

        while list1 and list2:
            if list1.val < list2.val:
                cur.next = list1
                list1 = list1.next
            else:
                cur.next = list2
                list2 = list2.next
            cur = cur.next

        cur.next = list1 if list1 else list2

        return dummy.next


if __name__ == "__main__":
    list1 = ListNode(1)
    list1.next = ListNode(2)
    list1.next.next = ListNode(4)

    list2 = ListNode(1)
    list2.next = ListNode(3)
    list2.next.next = ListNode(4)

    solution = MergeTwoSortedLists()
    result = solution.mergeTwoLists(list1, list2)
    print("Expected Output : 1 -> 1 -> 2 -> 3 -> 4 -> 4")
    print("Actual Output : ")
    while result:
        if result.next:
            print(result.val, end=" -> ")
        else:
            print(result.val)
        result = result.next
