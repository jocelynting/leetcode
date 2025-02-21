package designclass;

import java.util.*;

public class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            int lastElement = list.get(list.size() - 1);
            list.set(index, lastElement);
            map.put(lastElement, index);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet solution = new RandomizedSet();

        System.out.println(solution.insert(1)); // true
        System.out.println(solution.remove(2)); // false
        System.out.println(solution.insert(2)); // true
        System.out.println(solution.getRandom()); // 1 or 2
        System.out.println(solution.remove(1)); // true
        System.out.println(solution.insert(2)); // false
        System.out.println(solution.getRandom()); // 2
    }
}
