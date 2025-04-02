
import java.util.Arrays;
import java.util.Comparator;

public class n_meetings_in_one_room {

    static class meet {

        int start;
        int end;
        int posi;

        meet(int start, int end, int posi) {
            this.start = start;
            this.end = end;
            this.posi = posi;
        }
    }

    static public class meetComparator implements Comparator<meet> {

        @Override
        public int compare(meet m1, meet m2) {
            if (m1.end > m2.end) {
                return 1;
            } else if (m1.end < m2.end) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public int maxMeetings(int start[], int end[]) {
        int n = start.length;
        meet meetings[] = new meet[n];
        for (int i = 0; i < n; i++) {
            meetings[i] = new meet(start[i], end[i], i + 1);
        }
        Arrays.sort(meetings, new meetComparator());
        int count = 1;
        int lastend = meetings[0].end;
        for (int i = 1; i < n; i++) {
            if (meetings[i].start > lastend) {
                count++;
                lastend = meetings[i].end;
            }
        }
        return count;

    }
}
