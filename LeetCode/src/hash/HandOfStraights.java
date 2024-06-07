package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HandOfStraights {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Arrays.sort(hand);

        Map<Integer, Integer> map = new HashMap<>();

        for (int card: hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        for (int card: hand) {
            if (map.get(card) == 0) {
                continue;
            }

            for (int i = 0; i < groupSize; i++) {
                if (map.getOrDefault(card + i, 0) == 0) {
                    return false;
                }

                map.put(card + i, map.getOrDefault(card + i, 0) - 1);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        HandOfStraights solution = new HandOfStraights();

        // Test cases
        int[] hand1 = {1,2,3,6,2,3,4,7,8};
        int[] hand2 = {1,2,3,4,5};
        int[] hand3 = {1,2,3,4,5,6};
        int[] hand4 = {2,1};

        System.out.println(solution.isNStraightHand(hand1, 3)); // Output: true
        System.out.println(solution.isNStraightHand(hand2, 4)); // Output: false
        System.out.println(solution.isNStraightHand(hand3, 3)); // Output: true
        System.out.println(solution.isNStraightHand(hand4, 2)); // Output: true
    }
}

