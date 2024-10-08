public class pyramid {
    public static void main(String[] args) {
        pattern17(3);
    }

    static void pattern5(int n) {
        for (int row = 0; row < 2 * n; row++) {
            int totalColsInRow = row > n ? 2 * n - row : row;
            for (int col = 0; col < totalColsInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern31(int n) {
        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
            }
        }
    }

    static void pattern30(int n) {
        for (int row = 1; row <= n; row++) {
            int spaces = n - row;
            for (int sp = 0; sp < spaces; sp++) {
                System.out.print("  ");
            }
            for (int col = row; col >= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    static void pattern17(int n) {
        for (int row = 1; row < 2 * n; row++) {
            int totalColsInRow = row > n ? 2 * n - row : row;

            for (int sp = 0; sp < n - totalColsInRow; sp++) {
                System.out.print("  ");
            }
            for (int col = totalColsInRow; col >= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= totalColsInRow; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    static void pattern28(int n) {
        for (int row = 0; row < 2 * n; row++) {
            int totalColsInRow = row > n ? 2 * n - row : row;
            int spaces = n - totalColsInRow;
            for (int k = 0; k < spaces; k++) {
                System.out.print(" ");
            }
            for (int col = 0; col < totalColsInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

}
