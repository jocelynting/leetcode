from ListNode import ListNode
from typing import Optional

class LinkedListCycle:
  def hasCycle(self, head: Optional[ListNode]) -> bool:
        if not head or not head.next:
            return False
        
        slow, fast = head, head.next

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                return True
        return False
  
if __name__ == '__main__':
    solution = LinkedListCycle()
    
    node1 = ListNode(3)
    node2 = ListNode(2)
    node3 = ListNode(0)
    node4 = ListNode(-4)
    
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node2
    
    print("Test Case 1: Input: [3, 2, 0, -4], pos = 1")
    print("Expected Output: True")
    print("Actual Output:", solution.hasCycle(node1))
    
    node1.next = node2
    node2.next = node1
    
    print("Test Case 2: Input: [3, 2], pos = 0")
    print("Expected Output: True")
    print("Actual Output:", solution.hasCycle(node1))
    
    node1.next = None
    
    print("Test Case 3: Input: [3], pos = -1")
    print("Expected Output: False")
    print("Actual Output:", solution.hasCycle(node1))