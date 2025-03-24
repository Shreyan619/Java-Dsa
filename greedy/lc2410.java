
import java.util.Arrays;

// 2410. Maximum Matching of Players With Trainers
public class lc2410 {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int p = players.length, t = trainers.length;
        int left = 0, right = 0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        while (left < p && right < t) {
            if (players[left] <= trainers[right]) {
                left++;
            }
            right++;
        }
        return left;
    }
}
