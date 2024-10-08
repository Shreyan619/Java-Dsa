
import java.util.Arrays;

public class backtrack {

    public static void main(String[] args) {
        boolean[][] b = {
            {true, true, true},
            {true, true, true},
            {true, true, true}
        };
        int[][] path = new int[b.length][b[0].length];
        mazeobstacle("", b, 2, 2, 0, 2, path, 0);
    }

    static void mazeobstacle(String p,
            boolean[][] maze,
            int row,
            int col,
            int destRow,
            int destCol,
            int[][] path,
            int step) {
        if (row == destRow && col == destCol) {
            for (int[] arr : path) {
                System.err.println(Arrays.toString(arr));
            }
            System.err.println(p);
            System.err.println();
            return;
        }
        if (!maze[row][col]) {
            return;
        }

        maze[row][col] = false;
        path[row][col] = step;

        if (row < maze.length - 1) {
            mazeobstacle(p + 'D', maze, row + 1, col, destRow, destCol, path, step + 1);
        }

        if (col < maze[0].length - 1) {
            mazeobstacle(p + 'R', maze, row, col + 1, destRow, destCol, path, step + 1);
        }

        if (row > 0) {
            mazeobstacle(p + 'U', maze, row - 1, col, destRow, destCol, path, step + 1);
        }

        if (col > 0) {
            mazeobstacle(p + 'L', maze, row, col - 1, destRow, destCol, path, step + 1);
        }
        //this is the line where fucntion is over
        //when fucntion is over ,remove the changes and set the paths to true again
        maze[row][col] = true;
        path[row][col] = 0;
    }
}
