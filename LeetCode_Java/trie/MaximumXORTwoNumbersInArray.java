package trie;

public class MaximumXORTwoNumbersInArray {
    class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }
    public int findMaximumXOR(int[] nums) {
        int maxNum = nums[0];
        for (int num: nums) {
            maxNum = Math.max(maxNum, num);
        }

        int L = (Integer.toBinaryString(maxNum)).length();
        int maxXor = 0;

        TrieNode root = new TrieNode();
        for (int num: nums) {
            TrieNode node = root, xorNode = root;
            int currXor = 0;

            for (int i = L - 1; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int toggledBit = bit ^ 1;

                if (node.children[bit] == null) {
                    TrieNode newNode = new TrieNode();
                    node.children[bit] = newNode;
                }
                node = node.children[bit];

                if (xorNode.children[toggledBit] != null) {
                    currXor |= (1 << i);
                    xorNode = xorNode.children[toggledBit];
                } else {
                    xorNode = xorNode.children[bit];
                }
            }
            maxXor = Math.max(maxXor, currXor);
        }

        return maxXor;
    }

    public static void main(String[] args) {
        MaximumXORTwoNumbersInArray sol = new MaximumXORTwoNumbersInArray();

        int[] nums1 = {3, 10, 5, 25, 2, 8};
        System.out.println(sol.findMaximumXOR(nums1)); // Output: 28

        int[] nums2 = {14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70};
        System.out.println(sol.findMaximumXOR(nums2)); // Output: 127
    }
}
