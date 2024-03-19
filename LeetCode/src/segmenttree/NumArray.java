package segmenttree;

class NumArray {
    int[] segmentTree;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        segmentTree = new int[2 * n];
        System.arraycopy(nums, 0, segmentTree, n, n);
        for (int i = n - 1; i > 0; i--) {
            segmentTree[i] = segmentTree[2 * i] + segmentTree[2 *i +1];
        }
    }

    public void update(int index, int val) {
        index += n;
        segmentTree[index] = val;

        while (index > 1) {
            index >>= 1;
            segmentTree[index] = segmentTree[2 * index] + segmentTree[2 * index + 1];
        }
    }

    public int sumRange(int left, int right) {
        left += n;
        right += n;

        int res = 0;
        while (left <= right) {
            if (left % 2 == 1) {
                res += segmentTree[left];
                left += 1;
            }
            if (right % 2 == 0) {
                res += segmentTree[right];
                right -= 1;
            }

            left >>= 1;
            right >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        NumArray obj = new NumArray(nums);
        System.out.println(obj.sumRange(0, 2)); // Output: 9
        obj.update(1, 2);
        System.out.println(obj.sumRange(0, 2)); // Output: 8
    }
}

