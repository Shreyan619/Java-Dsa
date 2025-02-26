// 1358. Number of Substrings Containing All Three Characters

public class lc1258 {

    public int numberOfSubstrings(String s) {
        int lastSeen[] = {-1, -1, -1};
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            //b-a=1  ....c-a=2 ascii values
            lastSeen[s.charAt(i) - 'a'] = i; // Store the last seen index
// Find the minimum index among 'a', 'b', and 'c'
// Our goal is to find the smallest index among these three values, because that tells us where the first complete "abc" substring starts.
            int min = Math.min(Math.min(lastSeen[0], lastSeen[1]), lastSeen[2]);
            // If all characters are seen at least once, add valid substrings
            count += 1 + min;
        }
        return count;
    }
}
