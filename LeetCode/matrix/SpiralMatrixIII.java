package matrix;

public class SpiralMatrixIII {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int[] directions = {0, 1, 0, -1, 0};
        int r = rStart, c = cStart, step = 0, dir = 0, index = 0;

        result[index] = new int[]{r, c};
        index++;

        while (index < rows * cols) {
            if (dir == 0 || dir == 2) step++;

            for (int i = 0; i < step; i++) {
                r += directions[dir];
                c += directions[dir + 1];

                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    result[index] = new int[]{r, c};
                    index++;
                }
            }
            dir = (dir + 1) % 4;
        }

        return result;
    }

    public static void main(String[] args) {
        SpiralMatrixIII solution = new SpiralMatrixIII();
        int[][] result = solution.spiralMatrixIII(5, 6, 1, 4);
        for (int[] pos : result) {
            System.out.println("[" + pos[0] + ", " + pos[1] + "]");
        }
        //Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
    }
}
