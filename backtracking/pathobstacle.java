
public class pathobstacle {

    public static void main(String[] args) {
        boolean[][] b = {
            {true, true, true},
            {true, true, true},
            {true, true, true}
        };
        mazeobstacle("", b, 2, 2, 0, 2);
    }

    static void mazeobstacle(String p, boolean[][] maze, int row, int col, int destRow, int destCol) {
        if (row == destRow && col == destCol) {
            System.out.println(p);
            return;
        }
        if (!maze[row][col]) {
            return;
        }

        if (row < maze.length - 1) {
            mazeobstacle(p + 'D', maze, row + 1, col, destRow, destCol);
        }

        if (col < maze[0].length - 1) {
            mazeobstacle(p + 'R', maze, row, col + 1, destRow, destCol);
        }

        if (row > 0) {
            mazeobstacle(p + 'U', maze, row - 1, col, destRow, destCol);
        }

        if (col > 0) {
            mazeobstacle(p + 'L', maze, row, col - 1, destRow, destCol);
        }
    }
}
