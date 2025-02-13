
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
}
