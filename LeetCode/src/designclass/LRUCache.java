package designclass;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {
        LRUCacheByLinkedList cache1 = new LRUCacheByLinkedList(2);
        cache1.put(1, 1);
        cache1.put(2, 2);
        System.out.println(cache1.get(1)); // Output: 1
        cache1.put(3, 3);
        System.out.println(cache1.get(2)); // Output: -1
        cache1.put(4, 4);
        System.out.println(cache1.get(1)); // Output: -1
        System.out.println(cache1.get(3)); // Output: 3
        System.out.println(cache1.get(4)); // Output: 4

        LRUCacheByLinkedHashMap cache2 = new LRUCacheByLinkedHashMap(2);
        cache2.put(1, 1);
        cache2.put(2, 2);
        System.out.println(cache2.get(1)); // Output: 1
        cache2.put(3, 3);
        System.out.println(cache2.get(2)); // Output: -1
        cache2.put(4, 4);
        System.out.println(cache2.get(1)); // Output: -1
        System.out.println(cache2.get(3)); // Output: 3
        System.out.println(cache2.get(4)); // Output: 4
    }

}
class LRUCacheByLinkedList {
    private int capacity;
    private Map<Integer, ListNode> map;
    private ListNode head;
    private ListNode tail;

    public LRUCacheByLinkedList(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1,-1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        ListNode node = map.get(key);
        remove(node);
        add(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode oldNode = map.get(key);
            remove(oldNode);
        }

        ListNode node = new ListNode(key, value);
        map.put(key, node);
        add(node);

        if (map.size() > capacity) {
            ListNode removeNode = head.next;
            remove(removeNode);
            map.remove(removeNode.key);
        }
    }

    private void add(ListNode node) {
        ListNode tailPrev = tail.prev;
        tailPrev.next = node;
        node.prev = tailPrev;
        node.next = tail;
        tail.prev = node;
    }

    private void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class ListNode {
    int key;
    int val;
    ListNode prev;
    ListNode next;
    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCacheByLinkedHashMap {

    private int capacity;
    private LinkedHashMap<Integer, Integer> cache;

    public LRUCacheByLinkedHashMap(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
