
import java.util.Arrays;

//assign cookies
public class lc445 {

    public int findContentChildren(int[] g, int[] s) {
        int l = g.length, m = s.length;
        int left = 0, right = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (left < l && right < m) {
            if (g[right] <= s[left]) {
                left++;
            }
            right++;
        }
        return right;
    }
}
