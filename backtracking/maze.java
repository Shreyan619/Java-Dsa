
public class maze {

    public static void main(String[] args) {
        System.out.println(solveMaze(1, 1, 2, 3));
    }

    static int solveMaze(int row, int col, int targetRow, int targetCol) {
        if (row == targetRow || col == targetCol) {
            return 1;
        }
        int right = solveMaze(row, col + 1, targetRow, targetCol);
        int down = solveMaze(row + 1, col, targetRow, targetCol);
        return right + down;
    }
}
