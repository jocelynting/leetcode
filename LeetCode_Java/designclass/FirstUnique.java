package designclass;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstUnique {

    private Map<Integer, Integer> map;
    private Queue<Integer> queue;

    public FirstUnique(int[] nums) {
        map = new HashMap<>();
        queue = new LinkedList<>();

        for (int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        while (!queue.isEmpty() && map.get(queue.peek()) > 1) {
            queue.poll();
        }

        return queue.isEmpty() ? -1 : queue.peek();
    }

    public void add(int value) {
        map.put(value, map.getOrDefault(value, 0) + 1);
        if (map.get(value) == 1) {
            queue.offer(value);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        FirstUnique firstUnique = new FirstUnique(nums);
        System.out.println(firstUnique.showFirstUnique()); // return 2
        firstUnique.add(5);            // the queue is now [2,3,5,5]
        System.out.println(firstUnique.showFirstUnique()); // return 2
        firstUnique.add(2);            // the queue is now [2,3,5,5,2]
        System.out.println(firstUnique.showFirstUnique()); // return 3
        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        System.out.println(firstUnique.showFirstUnique()); // return -1
    }
}
