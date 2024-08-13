package matrix;

import java.util.List;

public class SnakeInMatrix {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int row = 0, col = 0;

        for (String c : commands) {
            switch (c) {
                case "UP":
                    row--;
                    break;
                case "DOWN":
                    row++;
                    break;
                case "LEFT":
                    col--;
                    break;
                case "RIGHT":
                    col++;
                    break;
            }
        }

        return row * n + col;

    }

    public static void main(String[] args) {
        SnakeInMatrix solution = new SnakeInMatrix();
        System.out.println(solution.finalPositionOfSnake(2, List.of(new String[]{"RIGHT", "DOWN"})));// Output: 3
        System.out.println(solution.finalPositionOfSnake(3, List.of(new String[]{"DOWN", "RIGHT", "UP"})));// Output: 1
    }
}
