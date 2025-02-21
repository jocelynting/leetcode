package matrix;

import linkedlist.ListNode;

public class SpiralMatrixIV {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        ListNode cur = head;
        while (cur != null && top <= bottom && left <= right) {
            for (int i = left; i <= right && cur != null; i++) {
                matrix[top][i] = cur.val;
                cur = cur.next;
            }
            top++;

            for (int i = top; i <= bottom && cur != null; i++) {
                matrix[i][right] = cur.val;
                cur = cur.next;
            }
            right--;

            for (int i = right; i >= left && cur != null; i--) {
                matrix[bottom][i] = cur.val;
                cur = cur.next;
            }
            bottom--;

            for (int i = bottom; i >= top && cur != null; i--) {
                matrix[i][left] = cur.val;
                cur = cur.next;
            }
            left++;
        }

        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrixIV solution = new SpiralMatrixIV();
        ListNode head = new ListNode(3);
        head.next = new ListNode(0);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(7);

        int[][] result = solution.spiralMatrix(3, 4, head);
        printMatrix(result);  // Expected output:
        // 3 0 2 6
        // -1 -1 -1 8
        // -1 -1 7 1
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
