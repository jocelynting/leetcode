package designclass;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOne {

    class ListNode {
        int count;
        ListNode prev;
        ListNode next;
        Set<String> keys;

        ListNode(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private ListNode head;
    private ListNode tail;
    private Map<String, ListNode> map;

    public AllOne() {
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            int count = node.count;
            node.keys.remove(key);

            ListNode next = node.next;
            if (next == tail || next.count != count + 1) {
                ListNode cur = new ListNode(count + 1);
                cur.keys.add(key);
                cur.prev = node;
                cur.next = next;
                node.next = cur;
                next.prev = cur;
                map.put(key, cur);
            } else {
                next.keys.add(key);
                map.put(key, next);
            }

            if (node.keys.isEmpty()) {
                removeNode(node);
            }
        } else {
            ListNode node = head.next;
            if (node == tail || node.count > 1) {
                ListNode cur = new ListNode(1);
                cur.keys.add(key);
                cur.prev = head;
                cur.next = node;
                head.next = cur;
                node.prev = cur;
                map.put(key, cur);
            } else {
                node.keys.add(key);
                map.put(key, node);
            }
        }
    }

    public void dec(String key) {
        if (!map.containsKey(key)) {
            return;
        }

        ListNode node = map.get(key);
        node.keys.remove(key);
        int count = node.count;

        if (count == 1) {
            map.remove(key);
        } else {
            ListNode prev = node.prev;
            if (prev == head || prev.count != count - 1) {
                ListNode cur = new ListNode(count - 1);
                cur.keys.add(key);
                cur.prev = prev;
                cur.next = node;
                prev.next = cur;
                node.prev = cur;
                map.put(key, cur);
            } else {
                prev.keys.add(key);
                map.put(key, prev);
            }
        }

        if (node.keys.isEmpty()) {
            removeNode(node);
        }
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }

    private void removeNode(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("hello");       // Add "hello" with count 1
        allOne.inc("hello");       // Increment "hello" to count 2
        allOne.inc("leet");        // Add "leet" with count 1
        allOne.dec("leet");        // Decrement "leet", remove it from the data structure
        System.out.println(allOne.getMaxKey()); // Should print "hello"
        System.out.println(allOne.getMinKey()); // Should print "hello"
    }
}
