
import java.util.Arrays;

public class geeksTraining {

    public int maximumPoints(int arr[][]) {
        int day = arr.length;
        int dp[][] = new int[day][4];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        return f(day - 1, 3, arr, dp);
    }

    private int f(int day, int last, int arr[][], int dp[][]) {
        if (dp[day][last] != -1) {
            return dp[day][last];
        }
        if (day == 0) {
            int maxi = 0;
            for (int task = 0; task <= 2; task++) {
                if (task != last) {
                    maxi = Math.max(maxi, arr[0][task]);
                }
            }
            return dp[day][last] = maxi;
        }
        int maxi = 0;
        for (int task = 0; task <= 2; task++) {
            if (task != last) {
                int activity = arr[day][task] + f(day - 1, task, arr, dp);
                maxi = Math.max(maxi, activity);
            }
        }
        return dp[day][last] = maxi;
    }

    private int tab(int[][] arr) {
        int n = arr.length;
        int dp[][] = new int[n][4];
        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][1], arr[0][0]);

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 3; last++) {
                dp[day][last] = 0;

                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int activity = arr[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }
        return dp[n - 1][3];
    }
}
