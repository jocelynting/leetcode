package designclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class TimeMap {
    public static void main(String[] args) {
        // Test case
        TimeMapByTreeMap timeMapByTreeMap = new TimeMapByTreeMap();
        timeMapByTreeMap.set("foo", "bar", 1);
        System.out.println(timeMapByTreeMap.get("foo", 1)); // Output: "bar"
        System.out.println(timeMapByTreeMap.get("foo", 3)); // Output: "bar"
        timeMapByTreeMap.set("foo", "bar2", 4);
        System.out.println(timeMapByTreeMap.get("foo", 4)); // Output: "bar2"
        System.out.println(timeMapByTreeMap.get("foo", 5)); // Output: "bar2"

        TimeMapByArrayBinarySearch timeMapByArrayBinarySearch = new TimeMapByArrayBinarySearch();
        timeMapByArrayBinarySearch.set("foo", "bar", 1);
        System.out.println(timeMapByArrayBinarySearch.get("foo", 1)); // Output: "bar"
        System.out.println(timeMapByArrayBinarySearch.get("foo", 3)); // Output: "bar"
        timeMapByArrayBinarySearch.set("foo", "bar2", 4);
        System.out.println(timeMapByArrayBinarySearch.get("foo", 4)); // Output: "bar2"
        System.out.println(timeMapByArrayBinarySearch.get("foo", 5)); // Output: "bar2"
    }
}

class TimeMapByTreeMap {
    HashMap<String, TreeMap<Integer, String>> timeMap;

    public TimeMapByTreeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!timeMap.containsKey(key)) {
            timeMap.put(key, new TreeMap<>());
        }
        timeMap.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }

        Integer floorKey = timeMap.get(key).floorKey(timestamp);
        if (floorKey != null) {
            return timeMap.get(key).get(floorKey);
        }

        return "";
    }
}

class TimeMapByArrayBinarySearch {
    HashMap<String, ArrayList<Pair<Integer, String>>> timeMap;

    public TimeMapByArrayBinarySearch() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!timeMap.containsKey(key)) {
            timeMap.put(key, new ArrayList<>());
        }
        timeMap.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }

        if (timestamp < timeMap.get(key).get(0).getKey()) {
            return "";
        }

        ArrayList<Pair<Integer, String>> timestamps = timeMap.get(key);

        return binarySearch(timestamps, 0, timestamps.size(), timestamp);
    }

    private String binarySearch(ArrayList<Pair<Integer, String>> timestamps, int left, int right, int timestamp) {

        while (left < right) {
            int mid = left + (right - left) / 2;

            int time = timestamps.get(mid).getKey();

            if (time <= timestamp) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        if (right == 0) {
            return "";
        }

        return timestamps.get(right - 1).getValue();
    }
}

class Pair <K, V> {
    K key;
    V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
